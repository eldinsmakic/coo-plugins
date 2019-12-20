
package fil.coo;

import java.awt.event.WindowAdapter;
import java.io.FilenameFilter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fil.coo.file.FileChecker;
import fil.coo.file.listeners.PrintFileListener;
import fil.coo.file.listeners.gui.JMenuFileListener;
import fil.coo.file.lister.ListFile;
import fil.coo.file.lister.ListFileBeginingWithCInFolder;
import fil.coo.file.lister.ListFilePluginFilter;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
	{
		JFrame mainWindow = new JFrame("TextFilter");
		JMenuBar barMenu = new JMenuBar();
		JTextArea textArea = new JTextArea(5,30);
		JScrollPane textSpace = new JScrollPane(textArea);
		textArea.setText("ceci est un exemple d'application utilisant un DP observer, le chargement dynamique et l'introspection\n" + 
				"\n" + 
				" Un voyage inattendu\n" + 
				"\n" + 
				"Bilbo Sacquet, Hobbit aventureux, reçut un jour la visite de\n" + 
				"Gandalf le magicien, accompagné de Thorin Oakenshield (chef très\n" + 
				"important parmi les nains) et de sa troupe constituée de 13 joyeux\n" + 
				"nains.\n" + 
				"\n" + 
				"Bilbo, séduit par l'idée de découvrir le monde, accepta la\n" + 
				"mission que lui proposait Thorin : récupérer le trésor des\n" + 
				"aïeux du nain , perdu lors de la terrible attaque de Smaug le\n" + 
				"dragon. Ainsi, un beau matin, les 14 nains, Bilbo et Gandalf partirent\n" + 
				"en direction de l'Ancien Royaume sous la Montagne des nains\n" + 
				"d'Erebor. Mais ce royaume se trouvait loin , et de grands dangers\n" + 
				"jalonnaient la route pour s'y rendre…");

		JMenuFileListener menu = new JMenuFileListener("Plugin",textArea);

		barMenu.add(menu);
		mainWindow.setJMenuBar(barMenu);
		mainWindow.add(textSpace);
		mainWindow.setSize(600, 600);

		mainWindow.setVisible(true);
		mainWindow.addWindowListener(new WindowAdapter()
			{
					public void windowClosing(java.awt.event.WindowEvent e) 
				{
					System.exit(0);
			    }	
			}  );


		ListFile listFilePlugin = new ListFilePluginFilter("../extensions/plugins");
		FileChecker fl = new FileChecker(listFilePlugin,2000);

		PrintFileListener printFileListener = new PrintFileListener();
		fl.addFileListener(printFileListener);
		fl.addFileListener(menu);
		System.out.println( "Hello World!" );

	}
}
