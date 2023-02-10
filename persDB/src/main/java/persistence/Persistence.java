package persistence;

import com.example.persdb.Person;
import model.PersonException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/****
 * generation of DB
 * create table PERSON
 * (
 *     ID int not null primary key,
 *     NAME VARCHAR(50) not null
 * );
 *
 * create table ADRESSE
 * (
 *     ID int not null primary key,
 *     NAME VARCHAR(50) not null,
 *     foreign key(ID) references PERSON(ID)
 * );
 */
public class Persistence {

    private static Persistence persistence;
    private final Connection connection;

    private Persistence() throws SQLException {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");
    }

    public static Persistence getInstance() throws SQLException {
        if(persistence == null)
            persistence = new Persistence();
        return persistence;
    }

    public Connection getConnection() {
        return connection;
    }

    public void insertPerson(Person person) throws SQLException, PersonException {
        try {
            PreparedStatement pPerson = connection.prepareStatement("insert into Person(id, name) values(?,?)");
            PreparedStatement pAdresse = connection.prepareStatement("insert into Adresse(id, name) values(?,?)");

            pPerson.setInt(1, person.getId());
            pPerson.setString(2, person.getName());

            pAdresse.setInt(1, person.getId());
            pAdresse.setString(2, person.getWohnort());

            pPerson.executeUpdate();
            pAdresse.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException e) {
            System.out.println(e.getErrorCode());
            if(e.getErrorCode() == 30000)
                throw new PersonException("Diese ID wurde schon vergeben!");
        }
    }

    public List<Person> getPeople() throws SQLException {
        Statement statement = Persistence.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT p.id, p.name, a.name as wohnort from Person p left join Adresse a using(id)");
        LinkedList<Person> personen = new LinkedList<>();
        while(rs.next()) {
            try {
                personen.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("wohnort")));
            }catch(PersonException ignored){}
        }

        return personen;
    }
}
