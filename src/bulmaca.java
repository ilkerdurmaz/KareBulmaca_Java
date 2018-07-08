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

		JButton jbtn= new JButton("Cevaplarý Göster");
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
				int sonuc=JOptionPane.showConfirmDialog(jfrm, "BULMACAYI TAMAMEN ÇÖZDÜNÜZ, YENÝ BULMACA YÜKLEMEK ÝSTER MÝSÝNÝZ?","TEBRÝKLER!",secim);
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
				JOptionPane.showMessageDialog(jfrm, "TEBRÝKLER BÜTÜN BULMACALARI ÇÖZDÜNÜZ!");
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
		int sonuc=JOptionPane.showConfirmDialog(jfrm, "Cevaplarý Görmek Ýstediðinize Emin Misiniz?","UYARI!",secim);
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
			 {"K","E","L","A","M","A","L","E","T","*","T","A","K","Ý","P","Ý","*","E","*","E","P","A","T","Ý","K"},
			 {"E","L","M","A","S","M","E","L","E","K","S","K","Ý","*","*","A","E","F","E","*","L","A","K","Ý","N"},
			 {"L","E","D","*","T","A","N","E","M","Ý","T","D","R","Ý","O","F","A","Y","*","*","Ý","M","A","*","*"},
			 {"Þ","*","H","A","N","A","M","A","*","E","H","A","M","I","Z","*","L","A","S","*","K","A","L","I","T"},
			 {"M","A","T","E","M","I","R","A","K","A","K","I","L","*","Ç","*","*","Ý","P","*","M","A","P","U","S"},
			 {"A","*","*","N","Ü","M","E","R","A","*","A","L","E","M","*","K","A","N","*","E","Ý","*","*","*","S"},
			 {"Ö","D","E","V","*","K","E","L","E","K","S","V","*","D","A","Ü","E","L","A","P","Z","O","R","*","I"},
			 {"M","E","R","A","K","*","T","Ý","*","Ý","U","L","U","A","*","*","Ý","L","A","N","L","A","*","N","Ü"},
			 {"K","E","L","A","M","O","L","A","N","A","K","A","N","A","L","U","*","E","*","*","*","A","T","E","Þ"},
			 {"S","E","Ç","Ý","M","O","*","Ý","Þ","*","R","O","L","*","*","G","*","E","L","*","U","L","A","M","A"},
			 };
	
			 public String[][] sdizi= new String[][]
				{
			 	{
			 		"Söyleyiþ biçimi,söz(1-5)",
			 		"Bir iþi gerçekleþtirmek için yapýlmýþ nesne(6-9)",
			 		"Ýzinden gitme, uyma, izleme(11-15)",
			 		"Örülerek yapýlan ayakkabý biçimindeki çorap(21-25)",
			 		"Erkek yazman(1-21)",
			 		"Gözde sarýya çalan kestane rengi(2-12)",
			 		"Kirliliði gösteren iz(3-18)",
			 		"Saðlam, dayanýklý(15-25)"
			 	},
			 	{
			 		"Billurlaþmýþ arý karbon(1-5)",
			 		"Terbiyeli, uysal kimse(6-10)",
			 		"Kayak(11-13)",
			 		"Batý Anadolu köy yiðidi(17-19)",
			 		"Ama, fakat(21-25)",
			 		"Benzer(1-21)",
			 		"Kirliliði gösteren iz(2-17)",
			 		"Tel(8-18)"
			 	},
			 	{
			 			
			 		"Iþýk yayan diyot(1-3)",
			 		"Kansýzlýk(6-10)",
			 		"Brezilya'da bir þehir(13-15)",
			 		"Kayaç kütlelerinin bir kýrýlma düzlemi(16-18)",
			 		"Dolaylý olarak anlatma(21-23)",
			 		"Vücut, beden, boy bos(2-22)",
			 		"Deniz(3-23)",
			 		"Boru sesi(5-10)"
			 	},
			 	{
			 		"Bir santranç taþý(1-11)",
			 		"Doðu ülkelerinde yerli bey ünvaný(3-5)",
			 		"Fakat, lakin(6-8)",
			 		"Asit(11-15)",
			 		"Miras(21-25)",
			 		"Taþýma iþi yapan kimse(3-23)",
			 		"Üçgen biçiminde sýva aracý(7-22)",
			 		"Bir enerji türü(14-24)"
			 	},
			 	{
			 		"Yas(1-5)",
			 		"Uzak(6-9)",
			 		"Tüy(11-13)",
			 		"Hapis(21-25)",
			 		"Arýnmýþ, katýþýksýz, saf(2-12)",
			 		"Ýsteyen, istekli(3-23)",
			 		"Eksiði tamamlamak için ona katýlan parça(4-9)",
			 		"Karþýlaþma(5-15)"
			 	},
			 	{
			 		"Çýplak resim(4-5)",
			 		"Otlak(6-9)",
			 		"Bayrak(11-14)",
			 		"Vücut sývýsý(16-18)",
			 		"Akdeniz bitki örtüsü(6-21)",
			 		"Gözde sarýya çalan kestane rengi(7-17)",
			 		"Ad, ün(4-14)",
			 		"Notada duraklama zamaný(20-25)"
			 	},
			 	{
			 		"Yapýlasý gerekli olan iþ(1-4)",
			 		"Olgunlaþmamýþ, ham kavun(6-10)",
			 		"Bir yere girip çýkarken geçilen duvar veya bölme açýklýðý(10-25)",
			 		"Gözde sarýya çalan kestane rengi(17-19)",
			 		"Sýkýntý, güç(21-23)",
			 		"Anasý veya hem anasý hem babasý ölmüþ olan(1-21)",
			 		"Hörgücü olan, geviþ getiren memeli(2-17)",
			 		"Ayrýlýrken birbirine selam ve esenlik dileme(4-19)"
			 		
			 	},
			 	{	
			 		"Bir þeyi anlamak veya öðrenmek için duyulan istek(1-5)",
			 		"Boru sesi(7-8)",
			 		"Millet(11-14)",
			 		"Duyuru(17-20)",
			 		"Bir nota(21-22)",
			 		"Çýplak resim(24-25)",
			 		"Dolgun, kalýn(2-17)",
			 		"Ün, þan, þöhret(14-24)"
			 	},
			 	{
			 		"Söz(1-5)",
			 		"Ulan! kýsaltmasý(7-9)",
			 		"Ýçinden damar, sinir veya bir sývý geçen yol(11-15)",
			 		"Yanýcý cisimlerin tutuþmasýyla beliren ýsý ve ýþýk(22-25)",
			 		"Zerrelerin burun zarý üzerindeki sinirlerde uyandýrdýðý duygu(1-16)",
			 		"Gözde sarýya çalan kestane rengi(2-12)",
			 		"Tanrý'nýn sevgi ve ilgisinden yoksun olma, beddua(3-23)",
			 		"Alýnýp satýlabilen her türlü ticaret eþyasý(5-15)"
			 	},
			 	{
			 		"Seçme iþi(1-5)",
			 		"Bir deðer yaratan emek(8-9)",
			 		"Bir iþte bir kimse veya þeyin üstüne düþen görev(11-13)",
			 		"Ýskambil oyunlarýnda her bir tur(18-19)",
			 		"Ulanan parça, ek, katký, ilave(21-25)",
			 		"Sorma iþi(1-21)",
			 		"Zahmet, sýkýntý(3-18)",
			 		"Alfabenin ilk harfi(25)"
			 	},
				};

}
