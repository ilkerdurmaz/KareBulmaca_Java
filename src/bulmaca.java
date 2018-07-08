import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;

	public class bulmaca implements ActionListener,KeyListener {

	
	 ArrayList<Integer> rast = new ArrayList<Integer>();
	 int rastgele;
	 JTextField jtfs[];
	 JLabel jlabs[];
	 JFrame jfrm = new JFrame("KARE BULMACA");
	 JPanel jpn_bulmaca = new JPanel();
	 JPanel jpn_sorular = new JPanel();
	 String yildiz=new String("*");
	
	 public bulmaca()
	{
		 	jtfs=new JTextField[25];

			jfrm.setSize(700,350);
			jfrm.setDefaultCloseOperation(3);
			
			JPanel jpn_ana = new JPanel();
			jpn_ana.setPreferredSize(new Dimension(690,290));
			jpn_ana.setLayout(new FlowLayout(FlowLayout.LEFT));
				
			jpn_bulmaca.setPreferredSize(new Dimension(250,250));
			jpn_bulmaca.setLayout(new GridLayout(5,5));
			
			jpn_sorular.setPreferredSize(new Dimension(420,250));
			jpn_sorular.setLayout(new FlowLayout());
			jpn_sorular.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.black), "Sorular",0, 0, null, Color.black));
		
			bulmacaYukle();

		for (int i = 0; i <bdizi[rastgele].length; i++) 
		 {
			 jtfs[i]=new JTextField(1);
			 jtfs[i].setHorizontalAlignment(JTextField.CENTER);
			 jtfs[i].addKeyListener(this);
			 jtfs[i].setText(i+1+"");
			 if(bdizi[rastgele][i].equals(yildiz))
			 {
				 jtfs[i].setEditable(false);
				 jtfs[i].setText("*");
			 }
			 else
			 { jtfs[i].setEditable(true);}
			 jpn_bulmaca.add(jtfs[i]);	 
	     }

		JButton jbtn= new JButton("Cevaplar� G�ster");
		jbtn.setPreferredSize(new Dimension(673, 40));
		jbtn.addActionListener(this);
		
		jpn_ana.add(jpn_bulmaca);
		jpn_ana.add(jpn_sorular);
		jpn_ana.add(jbtn);
		jfrm.add(jpn_ana);
		jfrm.setVisible(true);
	}

		public static void main(String[] args) {
			new bulmaca();
		}
		
		public void kontrol()
		{
			String harf=new String();
			String harfler=new String();
			for(int i=0;i<25;i++)
			{
				harf+=jtfs[i].getText();
				harfler+=bdizi[rastgele][i];
			}
			if(harf.equals(harfler))
			{
				int secim = JOptionPane.YES_NO_OPTION;
				int sonuc=JOptionPane.showConfirmDialog(jfrm, "BULMACAYI TAMAMEN ��ZD�N�Z, YEN� BULMACA Y�KLEMEK �STER M�S�N�Z?","TEBR�KLER!",secim);
				if(sonuc==0)
				{
					bulmacaYukle();
					for(int i=0;i<bdizi[rastgele].length;i++)
					 {
						 jtfs[i].setText(i+1+"");
						 if(bdizi[rastgele][i].equals(yildiz))
						 {
							 jtfs[i].setEditable(false);
							 jtfs[i].setText("*");
						 }
						 else
						 { jtfs[i].setEditable(true);} 
					 }
				}
				else
				{
					System.exit(0);
				}

			}
		}
		
		public void bulmacaYukle()
		{	
			Random rand=new Random();
			int rastgelen=rand.nextInt(10);
			if(!rast.contains(rastgelen))
			{
				rast.add(rastgelen);
				rastgele=rastgelen;
			}
			else if(rast.size()==10)
			{
				JOptionPane.showMessageDialog(jfrm, "TEBR�KLER B�T�N BULMACALARI ��ZD�N�Z!");
				System.exit(0);
			}
			else
			{
				bulmacaYukle();
			}

			jpn_sorular.setVisible(false);
			jpn_sorular.removeAll();
			for(int i=0;i<sdizi[rastgele].length;i++)
			 {
				 if(i==0){  jlabs=new JLabel[sdizi[rastgele].length];}
				
				 jlabs[i]= new JLabel(i+1+")"+sdizi[rastgele][i]);
				 jlabs[i].setMinimumSize(new Dimension(100, 23));
				 jlabs[i].setPreferredSize(new Dimension(400, 23));
				 jlabs[i].setMaximumSize(new Dimension(420, 25));
				 jpn_sorular.add(jlabs[i]);
				
			 }
			jpn_sorular.setVisible(true);
			jpn_bulmaca.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.black), rastgele+1+"."+"Bulmaca",0, 0, null, Color.black));
		}

	public void actionPerformed(ActionEvent arg0) 
	{
		int secim = JOptionPane.YES_NO_OPTION;
		int sonuc=JOptionPane.showConfirmDialog(jfrm, "Cevaplar� G�rmek �stedi�inize Emin Misiniz?","UYARI!",secim);
		if(sonuc==0)
		{
			for(int i=0;i<25;i++)
			{
				jtfs[i].setText(bdizi[rastgele][i]);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		kontrol();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		kontrol();
		
	}
	 public String[][] bdizi= new String[][]
			 {
			 {"K","E","L","A","M","A","L","E","T","*","T","A","K","�","P","�","*","E","*","E","P","A","T","�","K"},
			 {"E","L","M","A","S","M","E","L","E","K","S","K","�","*","*","A","E","F","E","*","L","A","K","�","N"},
			 {"L","E","D","*","T","A","N","E","M","�","T","D","R","�","O","F","A","Y","*","*","�","M","A","*","*"},
			 {"�","*","H","A","N","A","M","A","*","E","H","A","M","I","Z","*","L","A","S","*","K","A","L","I","T"},
			 {"M","A","T","E","M","I","R","A","K","A","K","I","L","*","�","*","*","�","P","*","M","A","P","U","S"},
			 {"A","*","*","N","�","M","E","R","A","*","A","L","E","M","*","K","A","N","*","E","�","*","*","*","S"},
			 {"�","D","E","V","*","K","E","L","E","K","S","V","*","D","A","�","E","L","A","P","Z","O","R","*","I"},
			 {"M","E","R","A","K","*","T","�","*","�","U","L","U","A","*","*","�","L","A","N","L","A","*","N","�"},
			 {"K","E","L","A","M","O","L","A","N","A","K","A","N","A","L","U","*","E","*","*","*","A","T","E","�"},
			 {"S","E","�","�","M","O","*","�","�","*","R","O","L","*","*","G","*","E","L","*","U","L","A","M","A"},
			 };
	
			 public String[][] sdizi= new String[][]
				{
			 	{
			 		"S�yleyi� bi�imi,s�z(1-5)",
			 		"Bir i�i ger�ekle�tirmek i�in yap�lm�� nesne(6-9)",
			 		"�zinden gitme, uyma, izleme(11-15)",
			 		"�r�lerek yap�lan ayakkab� bi�imindeki �orap(21-25)",
			 		"Erkek yazman(1-21)",
			 		"G�zde sar�ya �alan kestane rengi(2-12)",
			 		"Kirlili�i g�steren iz(3-18)",
			 		"Sa�lam, dayan�kl�(15-25)"
			 	},
			 	{
			 		"Billurla�m�� ar� karbon(1-5)",
			 		"Terbiyeli, uysal kimse(6-10)",
			 		"Kayak(11-13)",
			 		"Bat� Anadolu k�y yi�idi(17-19)",
			 		"Ama, fakat(21-25)",
			 		"Benzer(1-21)",
			 		"Kirlili�i g�steren iz(2-17)",
			 		"Tel(8-18)"
			 	},
			 	{
			 			
			 		"I��k yayan diyot(1-3)",
			 		"Kans�zl�k(6-10)",
			 		"Brezilya'da bir �ehir(13-15)",
			 		"Kaya� k�tlelerinin bir k�r�lma d�zlemi(16-18)",
			 		"Dolayl� olarak anlatma(21-23)",
			 		"V�cut, beden, boy bos(2-22)",
			 		"Deniz(3-23)",
			 		"Boru sesi(5-10)"
			 	},
			 	{
			 		"Bir santran� ta��(1-11)",
			 		"Do�u �lkelerinde yerli bey �nvan�(3-5)",
			 		"Fakat, lakin(6-8)",
			 		"Asit(11-15)",
			 		"Miras(21-25)",
			 		"Ta��ma i�i yapan kimse(3-23)",
			 		"��gen bi�iminde s�va arac�(7-22)",
			 		"Bir enerji t�r�(14-24)"
			 	},
			 	{
			 		"Yas(1-5)",
			 		"Uzak(6-9)",
			 		"T�y(11-13)",
			 		"Hapis(21-25)",
			 		"Ar�nm��, kat���ks�z, saf(2-12)",
			 		"�steyen, istekli(3-23)",
			 		"Eksi�i tamamlamak i�in ona kat�lan par�a(4-9)",
			 		"Kar��la�ma(5-15)"
			 	},
			 	{
			 		"��plak resim(4-5)",
			 		"Otlak(6-9)",
			 		"Bayrak(11-14)",
			 		"V�cut s�v�s�(16-18)",
			 		"Akdeniz bitki �rt�s�(6-21)",
			 		"G�zde sar�ya �alan kestane rengi(7-17)",
			 		"Ad, �n(4-14)",
			 		"Notada duraklama zaman�(20-25)"
			 	},
			 	{
			 		"Yap�las� gerekli olan i�(1-4)",
			 		"Olgunla�mam��, ham kavun(6-10)",
			 		"Bir yere girip ��karken ge�ilen duvar veya b�lme a��kl���(10-25)",
			 		"G�zde sar�ya �alan kestane rengi(17-19)",
			 		"S�k�nt�, g��(21-23)",
			 		"Anas� veya hem anas� hem babas� �lm�� olan(1-21)",
			 		"H�rg�c� olan, gevi� getiren memeli(2-17)",
			 		"Ayr�l�rken birbirine selam ve esenlik dileme(4-19)"
			 		
			 	},
			 	{	
			 		"Bir �eyi anlamak veya ��renmek i�in duyulan istek(1-5)",
			 		"Boru sesi(7-8)",
			 		"Millet(11-14)",
			 		"Duyuru(17-20)",
			 		"Bir nota(21-22)",
			 		"��plak resim(24-25)",
			 		"Dolgun, kal�n(2-17)",
			 		"�n, �an, ��hret(14-24)"
			 	},
			 	{
			 		"S�z(1-5)",
			 		"Ulan! k�saltmas�(7-9)",
			 		"��inden damar, sinir veya bir s�v� ge�en yol(11-15)",
			 		"Yan�c� cisimlerin tutu�mas�yla beliren �s� ve ���k(22-25)",
			 		"Zerrelerin burun zar� �zerindeki sinirlerde uyand�rd��� duygu(1-16)",
			 		"G�zde sar�ya �alan kestane rengi(2-12)",
			 		"Tanr�'n�n sevgi ve ilgisinden yoksun olma, beddua(3-23)",
			 		"Al�n�p sat�labilen her t�rl� ticaret e�yas�(5-15)"
			 	},
			 	{
			 		"Se�me i�i(1-5)",
			 		"Bir de�er yaratan emek(8-9)",
			 		"Bir i�te bir kimse veya �eyin �st�ne d��en g�rev(11-13)",
			 		"�skambil oyunlar�nda her bir tur(18-19)",
			 		"Ulanan par�a, ek, katk�, ilave(21-25)",
			 		"Sorma i�i(1-21)",
			 		"Zahmet, s�k�nt�(3-18)",
			 		"Alfabenin ilk harfi(25)"
			 	},
				};

}
