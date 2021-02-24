package application;

public class parser {
public static int [] parseDate(String date) {
	String[] tab=date.split("-");
	int [] tableau= new int[tab.length];
	for (int i=0;i<tableau.length;i++) {
		tableau[i]=Integer.parseInt(tab[i]);
	}
	return tableau;
}
}
