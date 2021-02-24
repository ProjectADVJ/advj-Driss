package application;
import java.sql.*;
import java.util.Date;


public class travel{

	static int id;
	String dateI= "2021-01-01";
	String dateE= "2021-04-01";
	String cityS;
	String cityD;
	int Nmax;
	String country;
	String logement;
	String sub_logement;
	double price;
	String url;
	
	public travel(String dateI, String dateE, String cityS, String cityD, int nmax, String country, String logement,
			String sub_logement, double price, String url) {
		super();
		this.dateI = dateI;
		this.dateE = dateE;
		this.cityS = cityS;
		this.cityD = cityD;
		Nmax = nmax;
		this.country = country;
		this.logement = logement;
		this.sub_logement = sub_logement;
		this.price = price;
		this.url = url;
	}
	public String getDateI() {
		return dateI;
	}
	public String getDateE() {
		return dateE;
	}
	public static void setId() throws SQLException {
		Connection conn= getConnexion();
		Statement myne= conn.createStatement();
		ResultSet monResultat=myne.executeQuery(" select max(id_v) as max from voyage");
		id= monResultat.getInt("max")+1;
	}
	
	public String getCityS() {
		return cityS;
	}
	public String getCityD() {
		return cityD;
	}
	public int getNmax() {
		return Nmax;
	}
	public String getCountry() {
		return country;
	}
	public int getId() throws SQLException {
		
		return id;
	}
	public String getLogement() {
		return logement;
	}
	public String getSub_logement() {
		return sub_logement;
	}
	public static Connection getConnexion() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/advtt?serverTimezone=UTC";
		
			Connection conn = DriverManager.getConnection(url,"root","mysql");
			
			return conn;
		
	}
	
	public static void addTravel(String DateI,String DateE,String CityS,
			String CityD, int NMax,String Country,String Logement,
			String sub_Logement, String prix, String lien) throws SQLException{
		Connection conn=getConnexion();
		//Create a Statement
		Statement myStmt = conn.prepareStatement("insert into voyage Values" 
				+ "(?,?,?,?,?,?,?,?,?,?,?)");
		((PreparedStatement) myStmt).setInt(1,2);
		((PreparedStatement) myStmt).setString(2, "2022-08-04");
		((PreparedStatement) myStmt).setString(3, "2022-08-04");
		((PreparedStatement) myStmt).setString(4, "Marrakech");
		((PreparedStatement) myStmt).setString(5, "Florence");
		((PreparedStatement) myStmt).setInt(6, 18);
		((PreparedStatement) myStmt).setString(7, "Italy");
		((PreparedStatement) myStmt).setString(8, "chalet");
		((PreparedStatement) myStmt).setString(9, "Hotel");
		((PreparedStatement) myStmt).setString(10, "14000");
		((PreparedStatement) myStmt).setString(11, "C:\\Users\\dell\\OneDrive\\Images\\cities project\\Florence.jpg");
		
		
		
		
		
		
		
		
		
		myStmt.execute();
		JOptionPane.showMessageDialog(null, "user added successefully");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
		//Execution de la commande sql
		setId();

		ResultSet monResultat = myStmt.executeQuery("select * from voyage");
		while(monResultat.next()) {
			System.out.println(monResultat.getString("id_v"));
			
			}
		}
	public travel() {
		super();
	}
	public void deleteTravel() throws SQLException{
		try {
			Connection conn = getConnexion();
			Statement myStmt = conn.createStatement();
			//Execution de la commande sql
			ResultSet monResultat = myStmt.executeQuery("Delete from voyage where id_v=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		}
	public void modifyTravel(String DateI,String DateE,String CityS
			,String CityD, int NMax,String Country,String Logement,
			String sub_Logement) {
		try {
			Connection conn= getConnexion();
			Statement myStmt = conn.createStatement();
			//Execution de la commande sql
			 myStmt.executeUpdate("UPDATE voyage"
					+ "SET id_v=setId dateI=DateI, dateE=DateE, cityD=Cityd, cityS=CityS"
					+ "Nmax=NMax,country=Country,logement=Logement,sub_logement"
					+ "=sub_Logement WHERE certainnesColonnes=CertainesValeurs;");

				ResultSet monResultat = myStmt.executeQuery("select * from voyage");
				while(monResultat.next()) {
					System.out.println(monResultat.getString("id_v"));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void main(String [] args) {
			try {
				
				Connection conn = getConnexion();
				Statement myStmt = conn.createStatement();
				//Execution de la commande sql
				ResultSet monResultat = myStmt.executeQuery("select * from voyage");
				while(monResultat.next()) {
				System.out.println(monResultat.getString("id_v"));
				addTravel("2022-08-04","2022-08-18","Marrakech","Florence",12,"Italy","chalet","hotel");
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

/*class connectionSql {
	public void main1(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/adv?serverTimezone=UTC";
		try {
			//connexion  la base de donnée
			Connection conn = DriverManager.getConnection(url,"root","mysql");
			//Create a Statement
			Statement myStmt = conn.createStatement();
			//Execution de la commande sql
			ResultSet monResultat = myStmt.executeQuery("select * from voyage");
			//extraire les résultats
			while (monResultat.next()) {
				System.out.println(monResultat.getString("dateI")+" "+monResultat.getString("dateE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/