import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
import javax.swing.table.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SecondFrame extends db_connect implements ActionListener {
	static int tamt=0;
	static String username = LoginForm.username;
	static int totalAmmount=0; 
	JComboBox Ccompany,Ccategory,cdiscount;
	JTextField searcht,medname,tmrp,tquant,dmanu,dexp,tupq,tupn,tupmrp,tupmrpn,tcsearch,tcname,tclocation, tcemail, tccontact, tupdemail, tupdcontact, tdeletec,tcupdname, nsnamet, nsquantityt,tpayableamt,fdatet,tdatet;
	JFrame f;
	JPasswordField old,nnew,conf;
	JButton medicines,companies,sale,addPro,cPass,cUser,dUser,update,searchb,addm,upd_quant,upd_price,expired,badd,bupq,bupmrp,expd,addc,updct, deletecomp,bcsearch, bcadd, bupdcontact, bdeletec, nsaddb, nsremoveb,jconfirm, getsale, updpassword, logout ;
	JLabel user, pSearch,img,searchl,mname,mrp,company,category,lquant,exp,manu,lupq,lupn,lupmrp,lupmrpn,lcsearch,lcname,lclocation, lcemail, lccontact, myinfoa, myinfob, myinfoc, myinfod, myinfoe, myinfof, myinfog, ludpemail,lupdcontact,ldeletec,lupdname,nsnamel,nsquantityl,lpayable,ldiscount,fdatel,tdatel,oldpass,newpass,confpass, ni;
	JPanel mp,cp,sp,pp,pwp,up,dp;
	JScrollPane sbe,sb,csb, nsp, soldMedp;      
	JTable tb,tbe,cst, nst, soldmedt;  
	DefaultTableModel model,modele,cmodel, nsm, soldMed; 
	//Labels oldpass,newpass,confpass	TextField old,nnew,conf	button updpassword	
		
	db_connect ob = new db_connect();
	public SecondFrame()
	{
		
		myinfoa = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfoa.setBounds(20,545,180,100);
		myinfoa.setVisible(true);
		
		
		myinfob = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfob.setBounds(20,545,180,100);
		myinfob.setVisible(true);
		
		myinfoc = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfoc.setBounds(20,545,180,100);
		myinfoc.setVisible(true);
		
		myinfod = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfod.setBounds(20,545,180,100);
		myinfod.setVisible(true);
		
		myinfoe = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfoe.setBounds(20,545,180,100);
		myinfoe.setVisible(true);
		
		myinfof = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfof.setBounds(20,545,180,100);
		myinfof.setVisible(true);
		
		myinfog = new JLabel("<html><font size='3' color=white><b>CREATED BY:<br>N-:Pratik Gawade<br>E-:pratikg4919@gmail.com<br> M-:8805985035</b></font></html>");
		myinfog.setBounds(20,545,180,100);
		myinfog.setVisible(true);
		
		f = new JFrame();
		f.setSize(1500,1500);
		f.setVisible(true);
		f.setTitle("HOME");
		f.setLayout(null);
		f.getContentPane().setBackground(Color.decode("#735c54"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("login1.png");    
		f.setIconImage(icon);

		img = new JLabel(new ImageIcon("login1.png"));
		img.setBounds(30,30,220,220);
		f.add(img);
		
		medicines = new JButton("Medicines");
		medicines.setBackground(Color.decode("#e8c1d8"));
		medicines.setOpaque(true);
		medicines.setBounds(35,270,220,30);
		f.add(medicines);	
		
		mp = new JPanel();
		mp.setLayout(null);
		mp.setBounds(330,40,900,650); 
		mp.setBackground(Color.gray);
		mp.setVisible(false);		
		f.add(mp);
		
		
		update = new JButton("Update");
		update.setBackground(Color.decode("#518fb5"));
		update.setBounds(20,250,150,25);	//20,15,150,25
		update.setOpaque(true);
		mp.add(update);
				
		addm = new JButton("Add new");	//first=(20,250,200,25) second=(220,250,200,25)
		addm.setBounds(20,250,200,25);
		addm.setBackground(Color.decode("#518fb5"));
		addm.setOpaque(true);
		addm.setVisible(false);
		mp.add(addm);
		
		mname = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		mname.setBounds(20,290,100,25);
		mname.setVisible(false);
		mp.add(mname);
		
		medname = new JTextField(30);
		medname.setBounds(80,290,300,30);
		medname.setVisible(false);	
		mp.add(medname);
		
		mrp = new JLabel("<html><font size='4' color=white><b>Price</b></font></html>");
		mrp.setBounds(500,290,100,25);
		mrp.setVisible(false);
		mp.add(mrp);
		
		tmrp = new JTextField(10);
		tmrp.setBounds(560,290,70,30);
		tmrp.setVisible(false);
		mp.add(tmrp);
		
		company = new JLabel("<html><font size='4' color=white><b>Company</b></font></html>");
		company.setBounds(20,350,100,25);
		company.setVisible(false);
		mp.add(company);
		
		tb = new JTable();  
		sb = new JScrollPane(tb);
		sb.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  
		sb.setBounds(15, 50, 860, 100);  
		mp.add(sb);
		
		model = new DefaultTableModel();
		model.addColumn("id");  
		model.addColumn("Name");  
		model.addColumn("Price");//
		model.addColumn("Quantity");
		model.addColumn("Category");
		model.addColumn("Expiry");  
		tb.setModel(model);
		
		tbe = new JTable();
		sbe = new JScrollPane(tbe);
		sbe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		sbe.setBounds(20,290,860,200);
		sbe.setVisible(false);
		mp.add(sbe);
		
		modele = new DefaultTableModel();
		modele.addColumn("Name");  
		modele.addColumn("Price");  
		modele.addColumn("Quantity");//
		modele.addColumn("Manufacture");
		modele.addColumn("Expiry");  
		tbe.setModel(modele);
		
		Ccompany = new JComboBox();
		Ccompany.setBounds(120,350,120,30);
		Ccompany.setVisible(false);
		mp.add(Ccompany);
		
		category = new JLabel("<html><font size='4' color=white><b>category</b></font></html>");
		category.setBounds(310,350,100,25);
		category.setVisible(false);
		mp.add(category);
		
		String s1[] = {"Tablet","Capsule","Drops","Inhaler","Injection","Syrup","Syringe","Soap","Powder","Gel","Oil","Sanitary"};
		Ccategory = new JComboBox(s1);
		Ccategory.setBounds(410,350,120,30);
		Ccategory.setVisible(false);
		mp.add(Ccategory);
		

		lquant = new JLabel("<html><font size='4' color=white><b>Quantity</b></font></html>");
		lquant.setBounds(600,350,100,25);
		lquant.setVisible(false);
		mp.add(lquant);
		
		tquant = new JTextField(30);
		tquant.setBounds(700,350,50,25);
		tquant.setVisible(false);
		mp.add(tquant);
		
		manu = new JLabel("<html><font size='4' color=white><b>Manufacture Date</b></font></html>");
		manu.setBounds(20,410,100,25);
		manu.setVisible(false);
		mp.add(manu);
		
		dmanu = new JTextField(30);
		dmanu.setBounds(130,410,100,25);
		dmanu.setVisible(false);
		mp.add(dmanu);
		
		exp = new JLabel("<html><font size='4' color=white><b>Expiry Date</b></font></html>");
		exp.setBounds(310,410,100,25);
		exp.setVisible(false);
		mp.add(exp);
		
		dexp = new JTextField(30);
		dexp.setBounds(420,410,100,25);
		dexp.setVisible(false);
		mp.add(dexp);
		
		badd = new JButton("ADD");
		badd.setBounds(40,470,150,25);
		badd.setOpaque(true);
		badd.setBackground(Color.decode("#518fb5"));
		badd.setVisible(false);
		mp.add(badd);

		upd_quant = new JButton("Update Quantity");
		upd_quant.setBounds(220,250,200,25);	
		upd_quant.setBackground(Color.decode("#518fb5"));
		upd_quant.setOpaque(true);
		upd_quant.setVisible(false);
		mp.add(upd_quant);
		
		//lupn tupn lupq tupq bupq
		lupn = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		lupn.setBounds(20,330,100,25);
		lupn.setVisible(false);
		mp.add(lupn);
		
		tupn = new JTextField(30);
		tupn.setBounds(80,330,300,30);
		tupn.setVisible(false);
		mp.add(tupn);
		
	 	lupq = new JLabel("<html><font size='4' color=white><b>New quantity</b></font></html>");
		lupq.setBounds(500,330,150,30);
		lupq.setVisible(false);
		mp.add(lupq);
		
		tupq = new JTextField(10);
		tupq.setBounds(630,330,70,30);
		tupq.setVisible(false);
		mp.add(tupq);
		
		bupq = new JButton("Update");
		bupq.setBounds(50,390,150,25);
		bupq.setVisible(false);
		bupq.setBackground(Color.decode("#518fb5"));
		bupq.setOpaque(true);
		mp.add(bupq);
		
		//text-tupmrpn,tupmrp	button-bupmrp	label- lupmrp, lupmrpn
		upd_price = new JButton("Update Price");
		upd_price.setBounds(420,250,200,25);	
		upd_price.setBackground(Color.decode("#518fb5"));
		upd_price.setOpaque(true);
		upd_price.setVisible(false);
		mp.add(upd_price);
			
		lupmrpn = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		lupmrpn.setBounds(20,330,100,25);
		lupmrpn.setVisible(false);
		mp.add(lupmrpn);
		
		
		tupmrpn = new JTextField(30);
		tupmrpn.setBounds(80,330,300,30);
		tupmrpn.setVisible(false);
		mp.add(tupmrpn);
		
		
	 	lupmrp = new JLabel("<html><font size='4' color=white><b>New Price</b></font></html>");
		lupmrp.setBounds(500,330,150,30);
		lupmrp.setVisible(false);
		mp.add(lupmrp);
		
		tupmrp = new JTextField(10);
		tupmrp.setBounds(630,330,70,30);
		tupmrp.setVisible(false);
		mp.add(tupmrp);
		
		bupmrp = new JButton("Update");
		bupmrp.setBounds(50,390,150,25);
		bupmrp.setVisible(false);
		bupmrp.setBackground(Color.decode("#518fb5"));
		bupmrp.setOpaque(true);
		mp.add(bupmrp);
		
		
		expired = new JButton("Expired");
		expired.setBounds(620,250,200,25);
		expired.setBackground(Color.decode("#518fb5"));
		expired.setOpaque(true);
		expired.setVisible(false);
		mp.add(expired);
		
		expd = new JButton("DELETE ALL EXPIRED STUFF");
		expd.setBackground(Color.decode("#4d8f35"));
		expd.setBounds(200,550,500,25); //40,470,150,25
		expd.setVisible(false);	
		expd.setOpaque(true);
		mp.add(expd);
		
		searchl = new JLabel("<html><font size='4' color=white><b>Search</b></font></html>");
		searchl.setBounds(20,15,60,30);	//20,70,60,30
		mp.add(searchl);
		
		searcht = new JTextField(30);
		searcht.setBounds(80,15,500,30);	//80,70,500,30
		mp.add(searcht);
		
		searchb = new JButton("Search");
		searchb.setBackground(Color.decode("#518fb5"));
		searchb.setBounds(600,15,100,25);	//600,70,100,25
		searchb.setOpaque(true);
		mp.add(searchb);	
		
		companies = new JButton("Companies");
		companies.setBackground(Color.decode("#e8c1d8"));
		companies.setOpaque(true);
		companies.setBounds(35,320,220,30);
		f.add(companies);
		

		cp = new JPanel();  
		cp.setBounds(330,40,900,650);    
		cp.setBackground(Color.gray);
		cp.setLayout(null);
		cp.setVisible(false);		
		f.add(cp);
		
		addc = new JButton("Add new");
		addc.setBounds(60,250,250,25);
		addc.setBackground(Color.decode("#518fb5"));
		addc.setOpaque(true);
		addc.setVisible(false);
		cp.add(addc);
		
		updct = new JButton("Update Contact");
		updct.setBounds(310,250,250,25);
		updct.setBackground(Color.decode("#518fb5"));
		updct.setOpaque(true);
		updct.setVisible(false);
		cp.add(updct);
		
		deletecomp = new JButton("Delete Company");
		deletecomp.setBounds(560,250,250,25);
		deletecomp.setBackground(Color.decode("#518fb5"));
		deletecomp.setOpaque(true);
		deletecomp.setVisible(false);
		cp.add(deletecomp);
		
		//label= lcsearch button=bcsearch txtfield=tcsearch
		bcsearch = new JButton("Search");
		bcsearch.setBackground(Color.decode("#518fb5"));
		bcsearch.setBounds(600,15,100,25);	//600,70,100,25
		bcsearch.setOpaque(true);
		cp.add(bcsearch);
		
		tcsearch = new JTextField(30);
		tcsearch.setBounds(80,15,500,30);	//80,70,500,30
		cp.add(tcsearch);
		//Jtable cst DefaultTableModel cmodel scrollpane csb
		cst = new JTable();  
		csb = new JScrollPane(cst);
		csb.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  
		csb.setBounds(15, 50, 860, 100);  
		cp.add(csb);
		
		cmodel = new DefaultTableModel();
		cmodel.addColumn("id");  
		cmodel.addColumn("Name");  
		cmodel.addColumn("Location");//
		cmodel.addColumn("Email");
		cmodel.addColumn("Contact");  
		cst.setModel(cmodel);
		
		lcsearch = new JLabel("<html><font size='4' color=white><b>Search</b></font></html>");
		lcsearch.setBounds(20,15,60,30);	//20,70,60,30
		cp.add(lcsearch);
		
		//label - lcname lclocation lcemail lccontact	textfield - tcname tclocation tcemail tccontact 	Jbutton bcadd
		lcname = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		lcname.setBounds(20,330,100,25);
		lcname.setVisible(false);
		cp.add(lcname);
		
		tcname = new JTextField(30);
		tcname.setBounds(80,330,300,30);
		tcname.setVisible(false);
		cp.add(tcname);
		
	 	lclocation = new JLabel("<html><font size='4' color=white><b>Location</b></font></html>");
		lclocation.setBounds(500,330,100,30);
		lclocation.setVisible(false);
		cp.add(lclocation);
		
		tclocation = new JTextField(10);
		tclocation.setBounds(580,330,250,30);
		tclocation.setVisible(false);
		cp.add(tclocation);
		
		lcemail = new JLabel("<html><font size='4' color=white><b>Email</b></font></html>");
		lcemail.setBounds(20,390,100,25);
		lcemail.setVisible(false);
		cp.add(lcemail);
		
		tcemail = new JTextField(30);
		tcemail.setBounds(80,390,300,30);
		tcemail.setVisible(false);
		cp.add(tcemail);
		
		lccontact = new JLabel("<html><font size='4' color=white><b>Contact</b></font></html>");
		lccontact.setBounds(500,390,100,30);
		lccontact.setVisible(false);
		cp.add(lccontact);
		
		tccontact = new JTextField(10);
		tccontact.setBounds(580,390,250,30);
		tccontact.setVisible(false);
		cp.add(tccontact);		
		
		bcadd = new JButton("ADD");
		bcadd.setBackground(Color.decode("#518fb5"));
		bcadd.setOpaque(true);
		bcadd.setVisible(false);
		bcadd.setBounds(50,450,100,25);
		cp.add(bcadd);
		
		//Email- lupdemail tupdemail	contact- lupdcontact tupdcontact	bupdcontact
		
		lupdname = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		lupdname.setBounds(20,330,100,25);
		lupdname.setVisible(false);
		cp.add(lupdname);
		
		tcupdname = new JTextField(30);
		tcupdname.setBounds(80,330,300,30);
		tcupdname.setVisible(false);
		cp.add(tcupdname);
		
	 	lupdcontact = new JLabel("<html><font size='4' color=white><b>Contact</b></font></html>");
		lupdcontact.setBounds(500,330,100,30);
		lupdcontact.setVisible(false);
		cp.add(lupdcontact);
		
		tupdcontact = new JTextField(10);
		tupdcontact.setBounds(580,330,250,30);
		tupdcontact.setVisible(false);
		cp.add(tupdcontact);
		
		ludpemail = new JLabel("<html><font size='4' color=white><b>Email</b></font></html>");
		ludpemail.setBounds(20,390,100,25);
		ludpemail.setVisible(false);
		cp.add(ludpemail);
		
		tupdemail = new JTextField(30);
		tupdemail.setBounds(80,390,300,30);
		tupdemail.setVisible(false);
		cp.add(tupdemail);
		
		bupdcontact = new JButton("Update");
		bupdcontact.setBackground(Color.decode("#518fb5"));
		bupdcontact.setOpaque(true);
		bupdcontact.setVisible(false);
		bupdcontact.setBounds(50,440,100,25);
		cp.add(bupdcontact);
		// ldeletec bdeletec tdeletec
		ldeletec = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		ldeletec.setBounds(20,330,100,25);
		ldeletec.setVisible(false);
		cp.add(ldeletec);
		
		tdeletec = new JTextField(30);
		tdeletec.setBounds(80,330,300,30);
		tdeletec.setVisible(false);
		cp.add(tdeletec);
		
		bdeletec = new JButton("Delete");
		bdeletec.setBackground(Color.decode("#518fb5"));
		bdeletec.setOpaque(true);
		bdeletec.setVisible(false);
		bdeletec.setBounds(50,390,100,25);
		cp.add(bdeletec);
		
		sale = new JButton("View Sale");
		sale.setBackground(Color.decode("#e8c1d8"));
		sale.setOpaque(true);
		sale.setBounds(35,370,220,30);
		f.add(sale);
		
		sp = new JPanel();
		sp.setLayout(null);  
		sp.setBounds(330,40,900,650);    
		sp.setBackground(Color.gray);
		sp.setVisible(false);		
		f.add(sp);
		
		//label = fdatel tdatel  Textfield= fdatet tdatet  button= getsale	model=soldMed	Scrollpane=soldMedp  Table=soldmedt
		fdatel = new JLabel("<html><font size='4' color=white><b>From</b></font></html>");
		fdatel.setBounds(180,25,100,25);
		fdatel.setVisible(true);
		sp.add(fdatel);
		
		fdatet = new JTextField(30);
		fdatet.setBounds(255,25,100,25);
		fdatet.setVisible(true);
		sp.add(fdatet);
		
		tdatel = new JLabel("<html><font size='4' color=white><b>TO</b></font></html>");
		tdatel.setBounds(395,25,100,25);
		tdatel.setVisible(true);
		sp.add(tdatel);
		
		tdatet = new JTextField(30);
		tdatet.setBounds(475,25,100,25);
		tdatet.setVisible(true);
		sp.add(tdatet);
		
		getsale = new JButton("View");
		getsale.setBackground(Color.decode("#518fb5"));
		getsale.setOpaque(true);
		getsale.setBounds(585,25,100,25);
		sp.add(getsale);
		
		//label = fdatel tdatel  Textfield= fdatet tdatet  button= getsale	model=soldMed	Scrollpane=soldMedp  Table=soldmedt
		soldmedt = new JTable();  
		soldMedp = new JScrollPane(soldmedt);
		soldMedp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  
		soldMedp.setBounds(15,70,860,450);  
		sp.add(soldMedp);
		
		soldMed = new DefaultTableModel();
		soldMed.addColumn("id");  
		soldMed.addColumn("Date");  
		soldMed.addColumn("Sold By");
		soldMed.addColumn("Name");
		soldMed.addColumn("Quantity");  
		soldmedt.setModel(soldMed);
		
		
		addPro = new JButton("New Sale");
		addPro.setBackground(Color.decode("#e8c1d8"));
		addPro.setOpaque(true);
		addPro.setBounds(35,420,220,30);
		f.add(addPro);
		//nsnamet, nsquantityt	nsnamel,nsquantityl	nsaddb
		
		pp = new JPanel();  
		pp.setBounds(330,40,900,650);    
		pp.setBackground(Color.gray);
		pp.setLayout(null);
		pp.setVisible(false);		
		f.add(pp);
		
		nsnamel = new JLabel("<html><font size='4' color=white><b>Name</b></font></html>");
		nsnamel.setBounds(20,20,100,25);
		nsnamel.setVisible(false);
		pp.add(nsnamel);
		
		nsnamet = new JTextField(30);
		nsnamet.setBounds(80,20,100,25);
		nsnamet.setVisible(false);
		pp.add(nsnamet);
		
	 	nsquantityl = new JLabel("<html><font size='4' color=white><b>Quantity</b></font></html>");
		nsquantityl.setBounds(280,20,100,30);
		nsquantityl.setVisible(false);
		pp.add(nsquantityl);
		
		nsquantityt = new JTextField(10);
		nsquantityt.setBounds(370,20,70,30);
		nsquantityt.setVisible(false);
		pp.add(nsquantityt);
		
		nsaddb = new JButton("Add");
		nsaddb.setBounds(530,20,100,25);
		nsaddb.setVisible(false);
		nsaddb.setBackground(Color.decode("#518fb5"));
		nsaddb.setOpaque(true);
		pp.add(nsaddb);
		
		nsremoveb = new JButton("Remove");
		nsremoveb.setBounds(680,20,100,25);
		nsremoveb.setVisible(true);
		nsremoveb.setBackground(Color.decode("#518fb5"));
		nsremoveb.setOpaque(true);
		pp.add(nsremoveb);
		
		nst = new JTable();  
		nsp = new JScrollPane(nst);
		nsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  
		nsp.setBounds(15,60,860,300);  
		pp.add(nsp);
		nsm = new DefaultTableModel();
		nsm.addColumn("id");  
		nsm.addColumn("Name");
		nsm.addColumn("Quantity"); 
		nsm.addColumn("Price");  
		nsm.addColumn("Total Price");
		nsm.addColumn("Expiry");
		nst.setModel(nsm);
		
		//button=jconfirm	label=lpayable,ldiscount	textfield=tpayableamt		Combobox=cdiscount
		lpayable = new JLabel("<html><font size='4' color=white><b>Payable Ammount</b></font></html>");
		lpayable.setBounds(15,400,200,30);
		lpayable.setVisible(true);
		pp.add(lpayable);
		
		tpayableamt = new JTextField(10);
		tpayableamt.setBounds(190,400,90,30);
		tpayableamt.setVisible(true);
		pp.add(tpayableamt);
		
		
		ldiscount = new JLabel("<html><font size='4' color=white><b>Apply Discount</b></font></html>");
		ldiscount.setBounds(400,400,200,30);
		ldiscount.setVisible(true);
		pp.add(ldiscount);
		
		String disc[] = {"0","10","20","30","40","50","60","70","80","90","100"};
		cdiscount = new JComboBox(disc);
		cdiscount.setBounds(540,400,70,30);
		cdiscount.setVisible(true);
		pp.add(cdiscount);
		
		jconfirm = new JButton("CONFIRM");
		jconfirm.setBackground(Color.decode("#518fb5"));
		jconfirm.setOpaque(true);
		jconfirm.setBounds(25,460,100,40);
		pp.add(jconfirm);
		
		cPass = new JButton("Change Password");
		cPass.setBackground(Color.decode("#e8c1d8"));
		cPass.setOpaque(true);
		cPass.setBounds(35,470,220,30);
		f.add(cPass);
		
		pwp = new JPanel();  
		pwp.setBounds(330,40,900,650);
		pwp.setLayout(null);    
		pwp.setBackground(Color.gray);
		pwp.setVisible(false);		
		f.add(pwp);
		
		oldpass = new JLabel("<html><font size='4' color=white><b>Current Password</b></font></html>");
		oldpass.setBounds(100,50,200,30);
		oldpass.setVisible(true);
		pwp.add(oldpass);
		
		old = new JPasswordField(15);
		old.setBounds(250,50,200,30);
		old.setVisible(true);
		pwp.add(old);
		
		newpass = new JLabel("<html><font size='4' color=white><b>New Password</b></font></html>");
		newpass.setBounds(100,130,200,30);
		newpass.setVisible(true);
		pwp.add(newpass);

		nnew = new JPasswordField(15);
		nnew.setBounds(250,130,200,30);
		nnew.setVisible(true);
		pwp.add(nnew);

		confpass = new JLabel("<html><font size='4' color=white><b>Confirm Password</b></font></html>");
		confpass.setBounds(100,230,200,30);
		confpass.setVisible(true);
		pwp.add(confpass);
		
		conf = new JPasswordField(15);
		conf.setBounds(250,230,200,30);
		conf.setVisible(true);
		pwp.add(conf);
		
		updpassword = new JButton("Update Password");
		updpassword.setBackground(Color.decode("#518fb5"));
		updpassword.setOpaque(true);
		updpassword.setBounds(100,330,200,30);
		pwp.add(updpassword);
		
		
		cUser = new JButton("Create User");
		cUser.setBackground(Color.decode("#e8c1d8"));
		cUser.setOpaque(true);
		cUser.setBounds(35,520,220,30);
		f.add(cUser);
		
		up = new JPanel();  
		up.setBounds(330,40,900,650);    
		up.setBackground(Color.gray);
		up.setVisible(false);		
		f.add(up);
		
		ni = new JLabel("<html><font size='20' color=white><b>NOT IMPLEMENTED</b></font></html>");
		ni.setBounds(100,100,500,100);
		ni.setVisible(true);
		up.add(ni);
		
		dUser = new JButton("Delete User");
		dUser.setBackground(Color.decode("#e8c1d8"));
		dUser.setOpaque(true);
		dUser.setBounds(35,570,220,30);
		f.add(dUser);
		
		logout = new JButton("LOGOUT");
		logout.setBackground(Color.decode("#e8c1d8"));
		logout.setOpaque(true);
		logout.setBounds(35,620,220,30);
		f.add(logout);
		
		dp = new JPanel();  
		dp.setBounds(330,40,900,650);    
		dp.setBackground(Color.gray);
		dp.setVisible(false);		
		f.add(dp);
		
		ni = new JLabel("<html><font size='20' color=white><b>NOT IMPLEMENTED</b></font></html>");
		ni.setVisible(true);
		dp.add(ni);
		
		mp.add(myinfoa);
		cp.add(myinfob);
		sp.add(myinfoc);
		pp.add(myinfod);
		pwp.add(myinfoe);
		up.add(myinfof);
		dp.add(myinfog);
				
		medicines.addActionListener(this);	
		companies.addActionListener(this);
		sale.addActionListener(this);
		addPro.addActionListener(this);
		cPass.addActionListener(this);
		cUser.addActionListener(this);
		dUser.addActionListener(this);
		update.addActionListener(this);
		addm.addActionListener(this);
		badd.addActionListener(this);	
		upd_quant.addActionListener(this);
		upd_price.addActionListener(this);
		expired.addActionListener(this);
		bupq.addActionListener(this);
		bupmrp.addActionListener(this);
		searchb.addActionListener(this);
		expd.addActionListener(this);
		bcsearch.addActionListener(this);
		addc.addActionListener(this);
		deletecomp.addActionListener(this);
		updct.addActionListener(this);
		bcadd.addActionListener(this);
		bupdcontact.addActionListener(this);
		bdeletec.addActionListener(this);
		nsaddb.addActionListener(this);
		nsremoveb.addActionListener(this);
		jconfirm.addActionListener(this);
		cdiscount.addActionListener(this);
		getsale.addActionListener(this);
		updpassword.addActionListener(this);
		logout.addActionListener(this);
	}
	
		public static boolean vman(String date2)
		{
			try
			{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String date1=dateFormat.format(date);
			Date cdate = dateFormat.parse(date1);
		    	Date mdate = dateFormat.parse(date2);
		    	
		    	if(cdate.after(mdate))
		    	{
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("Exception-"+e);
		    	}
		    	return true;
		}
		
		public static boolean vmann(String date1, String date2)
		{
			try
			{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			Date mdate = dateFormat.parse(date1);
		    	Date edate = dateFormat.parse(date2);
		    	
		    	if(edate.after(mdate))
		    	{
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("Exception-"+e);
		    	}
		    	return true;
		}
	
	
	
	
	public static boolean isDate(String sdate)
	{
		if (sdate.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/mm/dd");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
		     */
		    try
		    {
			Date javaDate = sdfrmt.parse(sdate); 
			//System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
			//System.out.println(strDate+" is Invalid Date format");
			return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	}
	
	public void companybox()
	{
		try{
			Connection con = ob.getConnection();
			String query = "select * from company";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Ccompany.addItem(rs.getString("cname"));
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	public static boolean isNumber(String s)
	{
		try
		{
        		 Integer.parseInt(s);
    		}
    		catch (NumberFormatException nfe)
    		{
        		return false;
    		}
    		return true;
	}
	
	public static boolean isPossitive(String s)
	{
		try
		{
			int ispos=Integer.parseInt(s);
			if(ispos>=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(NumberFormatException ne)
		{
			return false;
		}
	}
	
	public int isMedicine(String name)
	{
		int count=0;
		try
		{
			Connection con = ob.getConnection();
			String queryn = "select * from medicines where name=?";
			PreparedStatement pstm = con.prepareStatement(queryn);
			pstm.setString(1,name);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				count++;	
			}
			return count;
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
		return count;
	}
	
	public int isMedicineToRem(String name)
	{
		int count=0,mid=0;
		try
		{
			Connection con = ob.getConnection();
			String q="select mid from medicines where name=?";//String queryn = "select * from new_sales where name=?";
			PreparedStatement pstm = con.prepareStatement(q);
			pstm.setString(1,name);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				mid = rs.getInt("mid");	
			}
			String queryn = "select * from new_sales where mid=?";
			pstm = con.prepareStatement(queryn);
			pstm.setInt(1,mid);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				count++;
			}
			return count;
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
		return count;
	}
	public boolean quantAvail(String name,String quantity)
	{
		try
		{
		Connection con = ob.getConnection();
		int quant = Integer.parseInt(quantity);
		int aquant=0;
		String fquery="select quantity from medicines where name=?";
		PreparedStatement st = con.prepareStatement(fquery);
		st.setString(1,name);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
			aquant = rs.getInt("quantity");
		}
		if(aquant-quant<0)
		{
			return false;
		}
		return true;
		}
		catch(Exception e)
		{	
			System.out.println("Exception caught-"+e);
		}
		return true;
	}
	
	public void removeMed()
	{
		String name = nsnamet.getText();
		int mid = 0;
		int count = 0;
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog (null, "Please Enter Medicine Name");
		}
		else
		{
			count=isMedicineToRem(name);
			if(count==0)
			{
				JOptionPane.showMessageDialog (null, "NO medicine added named="+name);
			}
			else
			{
				try
				{
					Connection con = ob.getConnection();
					String fquery="select mid from medicines where name=?";
					PreparedStatement st = con.prepareStatement(fquery);
					st.setString(1,name);
					ResultSet rs = st.executeQuery();
					if(rs.next())
					{
						mid = rs.getInt("mid");
					}
					
					
					String query = "delete from new_sales where mid=?;";
					st = con.prepareStatement(query);
					st.setInt(1,mid);
					st.executeUpdate();
					Ntab();
				}
				catch(Exception e)
				{
					System.out.println("Exception caught-"+e);
				}
			}
		}
	}
		
		public void Ntab()
		{
			try
			{
				String[] name = new String[20];
				int[] mid = new int[20];
				int[] quant = new int[20];
				int[] price = new int[20];
				int[] ammount = new int[20];
				String[] expiry = new String[20];
				int i=0,j=0;
				int upd_price=0;
				
				Connection con = ob.getConnection(); 
				String fquery="select * from new_sales";
				PreparedStatement st = con.prepareStatement(fquery);
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
						mid[i] = rs.getInt("mid");	
						quant[i] = rs.getInt("quantity");
						i++;
						j=i;
				}
				
				String q;
				for(i=0;i<=j;i++)
				{
					q="select name,price,expiry from medicines where mid=?";
					st = con.prepareStatement(q);
					st.setInt(1,mid[i]);
					rs = st.executeQuery();
					while(rs.next())
					{
						
						name[i] = rs.getString("name");
						price[i] = rs.getInt("price");
						expiry[i] = rs.getString("expiry");
						ammount[i] = price[i] * quant[i];
						
						upd_price=upd_price + ammount[i]; 
					}
					totalAmmount= upd_price;
					tpayableamt.setText(Integer.toString(totalAmmount));
				}
					nsm.setRowCount(0);
					for(i=0;i<=j;i++)
					{
						nsm.addRow(new Object[]{mid[i],name[i],quant[i],price[i],ammount[i],expiry[i]});
					}
					 
			}
			
			catch(Exception e)
			{
				System.out.println("Exception caught="+e);
			}
		}
		
		
	public void saleMed()
	{
		//nsnamet, nsquantityt		nsaddb nsremoveb
		String name = nsnamet.getText();
		String quantity =  nsquantityt.getText();
		if(name.isEmpty() || quantity.isEmpty())
		{
			JOptionPane.showMessageDialog (null, "Please Enter All Fields");
		}
		else
		{
			int count=0;
			count = isMedicine(name);
			if(count==0)
			{
				JOptionPane.showMessageDialog (null, "Invalid Medicine name");
			}
			else if(!isNumber(quantity))
			{
				JOptionPane.showMessageDialog (null, "Invalid Quantity");
			}
			else if(!isPossitive(quantity))
			{
				JOptionPane.showMessageDialog (null, "Quantity Must Be Possitive");
			}
			else if(count==1 && isNumber(quantity) && isPossitive(quantity))
			{
				try
				{
				Connection con = ob.getConnection();
				int quant = Integer.parseInt(quantity);
				int mid=0, uid=0; 
				String fquery="select mid from medicines where name=?";
				PreparedStatement st = con.prepareStatement(fquery);
				st.setString(1,name);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					mid = rs.getInt("mid");
				}
				
					String query="select uid from users where email=?";
					PreparedStatement stm = con.prepareStatement(query);
					stm.setString(1,username);
					ResultSet rst = stm.executeQuery();
				
					if(rst.next())
					{
						uid = rst.getInt("uid");
					}
					
					if(!quantAvail(name,quantity))
					{
						JOptionPane.showMessageDialog (null, "Quantity Not Available");
					}
					else
					{
					int price=0;
					int amt=0;
					String expiry=null;
					query="select price,expiry from medicines where name=?";
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1,name);
					rst = stmt.executeQuery();
					if(rst.next())
					{
						price = rst.getInt("price");
						totalAmmount = totalAmmount + price; 
						expiry = rst.getString("expiry");
						amt = price*quant;
						tamt=tamt+amt;
					}
					totalAmmount = tamt;
					nsm.addRow(new Object[]{mid,name,quantity,price,amt,expiry});
					tpayableamt.setText(Integer.toString(totalAmmount));
					query="insert into new_sales(mid,quantity,uid) values(?,?,?)";
					stmt = con.prepareStatement(query);
					stmt.setInt(1,mid);
					stmt.setInt(2,quant);
					stmt.setInt(3,uid);
					int n = stmt.executeUpdate();

					}
				}
				catch(Exception e)
				{
					System.out.println("Exception caught="+e);
				}
				
				//modele.addRow(new Object[]{id,name,expiry,price});
			}
			
		}
	}
	
	public void confirmBilling()
	{
		try
		{
			int[] mid = new int[20];
			int[] uid = new int[20];
			int[] nid = new int[20];
			int[] quantity = new int[20];
			int[] fq = new int[20];
			int[] aq = new int[20];
			int count=0,i=0;
			Connection con = ob.getConnection();
			String fquery="select * from new_sales";
			PreparedStatement st = con.prepareStatement(fquery);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				mid[i] = rs.getInt("mid");
				uid[i] = rs.getInt("uid");
				nid[i] = rs.getInt("nid");
				quantity[i] = rs.getInt("quantity");
				count++;
				i++;
			}
			
			if(count<1)
			{
				JOptionPane.showMessageDialog (null, "Please insert products to sale");
			}
			else
			{
			
				for(i=0;i<count;i++)
				{
					String gq = "select quantity from medicines where mid=?";
					st = con.prepareStatement(gq);
					st.setInt(1,mid[i]);
					rs = st.executeQuery();
					while(rs.next())
					{
						fq[i]=rs.getInt("quantity");
						aq[i]= fq[i] - quantity[i]; 
					}
					
				}
				
				for(i=0;i<count;i++)
				{
					String dquery="update medicines set quantity=? where mid=?";
					st = con.prepareStatement(dquery);
					st.setInt(1,aq[i]);
					st.setInt(2,mid[i]);
					st.executeUpdate();
				}
				
				for(i=0;i<count;i++)
				{
					String que = "insert into sales(mid,quantity,uid) values(?,?,?)";
					st = con.prepareStatement(que);
					st.setInt(1,mid[i]);
					st.setInt(2,quantity[i]);
					st.setInt(3,uid[i]);
					st.executeUpdate();	
				}
				fquery = "truncate new_sales cascade";
				st = con.prepareStatement(fquery);
				st.executeUpdate();
								
				nsm.setRowCount(0);
				tpayableamt.setText(null);
				totalAmmount=totalAmmount - totalAmmount;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception caught="+e);
		}
	}
	
	public void displaySold()
	{
	try{
		String[] email = new String[100];
		String[] name = new String[100];
		int[] mid = new int[100];
		int[] uid = new int[100];
		int[] sid = new int[100];
		int[] quantity = new int[100];
		Date[] date = new Date[100];
		int i=0,count=0;
		Connection con = ob.getConnection();
		String fquery="select * from sales";
		PreparedStatement st = con.prepareStatement(fquery);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			date[i] = rs.getTimestamp("date");
			mid[i] = rs.getInt("mid");
			uid[i] = rs.getInt("uid");
			sid[i] = rs.getInt("sid");
			quantity[i] = rs.getInt("quantity");
			i++;
			count++;
		}
		
		for(i=0;i<count;i++)
		{
			fquery = "select name from medicines where mid=?";
			st = con.prepareStatement(fquery);
			st.setInt(1,mid[i]);
			rs = st.executeQuery();
			if(rs.next())
			{
				name[i] = rs.getString("name");
			}
		}
		
		for(i=0;i<count;i++)
		{
			fquery = "select email from users where uid=?";
			st = con.prepareStatement(fquery);
			st.setInt(1,uid[i]);
			rs = st.executeQuery();
			if(rs.next())
			{
				email[i] = rs.getString("email");
			}
		}
		
		soldMed.setRowCount(0);
		for(i=0;i<count;i++)
		{
			soldMed.addRow(new Object[]{sid[i],date[i],email[i],name[i],quantity[i]});
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception caught"+e);
	}
		
	}
	
	public void updateQuantity(String medName,String medQuant)
	{
		
		if(medName.isEmpty() || medQuant.isEmpty()) 
		{
			JOptionPane.showMessageDialog (null, "Please Enter All Fields");
		}
		
		if(!isNumber(medQuant))
		{
			JOptionPane.showMessageDialog (null, "Quantity must be number");
		}
		else
		{
			int tr = Integer.parseInt(medQuant);
			if(tr<0)
			JOptionPane.showMessageDialog (null, "Quantity must be POSSITIVE");
		}
	
		if(isNumber(medQuant) && isPossitive(medQuant))
		{
			try{
				int ct;
				ct = isMedicine(medName);
				if(ct==0)
				{
					JOptionPane.showMessageDialog (null, medName+" not found in database");
				}
				else
				{
					Connection con = ob.getConnection();
					int neq = Integer.parseInt(medQuant);
					String fquery="update medicines set quantity=? where name=?";
					PreparedStatement st = con.prepareStatement(fquery);
					st.setInt(1,neq);
					st.setString(2,medName);
					st.executeUpdate();
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception caught In Update Quantity="+e);
			}
			JOptionPane.showMessageDialog (null, "Quantity Updated: Name="+medName+" Quantity="+medQuant);
		}
			
	}
	
	
	public void updatePrice(String medName,String medp)
	{
		if(medName.isEmpty() || medp.isEmpty()) 
		{
			JOptionPane.showMessageDialog (null, "Please Enter All Fields");
		}
		
		if(!isNumber(medp))
		{
			JOptionPane.showMessageDialog (null, "MRP must be number");
		}
		else
		{
			int tr = Integer.parseInt(medp);
			if(tr<=0)
			JOptionPane.showMessageDialog (null, "MRP must be Greater than 0");
		}
	
		if(isNumber(medp) && isPossitive(medp))
		{
				int ct=0;
				ct = isMedicine(medName);
				if(ct==0)
				{
					JOptionPane.showMessageDialog (null, medName+" not found in database");
				}
				else
				{
				try{
					Connection con = ob.getConnection();
					int neq = Integer.parseInt(medp);
					String fquery="update medicines set price=? where name=?";
					PreparedStatement st = con.prepareStatement(fquery);
					st.setInt(1,neq);
					st.setString(2,medName);
					st.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println("Exception caught in update price="+e);
				}
				
				}
			JOptionPane.showMessageDialog (null, "MRP Updated: Name="+medName+" MRP="+medp);
		}
			
	}
	
	public void getExpired()
	{
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String date1=dateFormat.format(date);
			Date cdate = dateFormat.parse(date1);
			
		    	Connection con = ob.getConnection();
			String searchexp = "select name,price,quantity,expiry,manufacture from medicines";
			PreparedStatement p = con.prepareStatement(searchexp);
			ResultSet rs=p.executeQuery();
			modele.setRowCount(0);
			while(rs.next())
			{
		        	String name = rs.getString("name");
		        	int price = rs.getInt("price");
		        	int quantity = rs.getInt("quantity");
		        	String manufacture = rs.getString("manufacture");
		        	String date2 = rs.getString("expiry");
		        	Date expiry = dateFormat.parse(date2);
		        	if(cdate.after(expiry))
		        	{
		        		modele.addRow(new Object[]{name,price,quantity,manufacture,date2});
		        	}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
	}
	
	public void deleteExp()
	{
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String date1=dateFormat.format(date);
			Date cdate = dateFormat.parse(date1);
			
		    	Connection con = ob.getConnection();
			String searchexp = "select name,expiry from medicines";
			PreparedStatement p = con.prepareStatement(searchexp);
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
		        	String name = rs.getString("name");
		        	String date2 = rs.getString("expiry");
		        	Date expiry = dateFormat.parse(date2);
		        	if(cdate.after(expiry))
		        	{
		        		String d ="delete from medicines where name=?";
		        		p = con.prepareStatement(d);
		        		p.setString(1,name);
		        		p.executeUpdate();
		        	}
			}
			JOptionPane.showMessageDialog(f,"DELETED ALL EXPIRED.","Alert",JOptionPane.WARNING_MESSAGE);     
			modele.setRowCount(0);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
	}
	
	public static boolean isValid(String email)
	{
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";               
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
    	}
    	
	public static boolean isValidContact(String s)
	{
    		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}
	
	public void addCompany()
	{
		//tcname tclocation tcemail tccontact
		String Name = tcname.getText();
		String Location = tclocation.getText();
		String Email = tcemail.getText();
		String Contactstr = tccontact.getText();
		
		
		if(Name.isEmpty() || Location.isEmpty() || Email.isEmpty() || Contactstr.isEmpty()) 
		{
			JOptionPane.showMessageDialog (null, "All Fields Are Compulsory");
		}
		else
		{
			if(!isValidContact(Contactstr))
			{
				JOptionPane.showMessageDialog (null, "Contact must be Number");
			}
			if(!isValid(Email))
			{
				JOptionPane.showMessageDialog (null, "INVALID EMAIL");
			}
			if(isValidContact(Contactstr) && isValid(Email))
			{
				Connection con = ob.getConnection();
				
				try{
	String q = "insert into company(cname,location,email,contact) values(?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(q);
						long Contact = Long.parseLong(Contactstr);  
						  
						pst = con.prepareStatement(q);
						pst.setString(1,Name);
						pst.setString(2,Location);
						pst.setString(3,Email);
						pst.setLong(4,Contact);
						pst.executeUpdate();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
					JOptionPane.showMessageDialog (null, Name+" added successfully");
			}
		}
		
	}
	
	public boolean isCompany(String name)
	{
		Connection con = ob.getConnection();
			try
			{
			String q = "select * from company where cname=?";
			PreparedStatement pst = con.prepareStatement(q);    
					
			pst = con.prepareStatement(q);
			pst.setString(1,name);
			ResultSet rs = pst.executeQuery();
			int count=0;
				while(rs.next())
				{
					count++;
				}
				
				if(count==0)
				{
					return false;
				}
				return true;	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return true;
	}
	public void updateContact()
	{
		//tupdcontact tupdemail bupdcontact
		String name = tcupdname.getText();
		String Contactstr = tupdcontact.getText();
		String Email = tupdemail.getText();
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog (null, "Please enter a company name");
		}
		else if(!isCompany(name))
		{
			JOptionPane.showMessageDialog (null, "Please enter Valid company name");
		}
		
		if(Email.isEmpty() && isCompany(name))
		{
			if(!isValidContact(Contactstr))
			{
				JOptionPane.showMessageDialog (null, "Please enter valid contact number");
			}
			else
			{
				Connection con = ob.getConnection();
				try
				{
				String q = "update company set contact=? where cname=?";
					PreparedStatement pst = con.prepareStatement(q);
					long Contact = Long.parseLong(Contactstr);    
						
				pst = con.prepareStatement(q);
				pst.setLong(1,Contact);
				pst.setString(2,name);
				pst.executeUpdate();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				JOptionPane.showMessageDialog (null, name+" Contact Updated New Contact Number="+Contactstr);
			}
		}
		else if(Contactstr.isEmpty() && isCompany(name))
		{
			if(!isValid(Email))
			{
				JOptionPane.showMessageDialog (null, "Please enter Valid Email Address");
			}
			else
			{
				Connection con = ob.getConnection();
				try
				{
				String q = "update company set email=? where cname=?";
					PreparedStatement pst = con.prepareStatement(q);    
						
				pst = con.prepareStatement(q);
				pst.setString(1,Email);
				pst.setString(2,name);
				pst.executeUpdate();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				JOptionPane.showMessageDialog (null, name+" Email Updated New Email="+Email);
			}
		}
		else if(Email.isEmpty() && Contactstr.isEmpty())
		{
			JOptionPane.showMessageDialog (null, "Please enter new Email or Contact to be updated");
		}
		else
		{
			JOptionPane.showMessageDialog (null, "Please Update only one field at a time");
		}
				
	}
	
	public void deleteCompany(String name)
	{
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog (null, "Please enter company name to be deleted");
		}
		else
		{
			if(!isCompany(name))
			{
				JOptionPane.showMessageDialog (null, "Please enter Valid company name");
			}
			else
			{
				Connection con = ob.getConnection();
				try
				{
				String q = "delete from company where cname=?";
				PreparedStatement pst = con.prepareStatement(q);		
				pst = con.prepareStatement(q);
				pst.setString(1,name);
				pst.executeUpdate();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				JOptionPane.showMessageDialog (null, name+" Deleted from company list");
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{				
		if(ae.getSource()==medicines)
		{
			Ccompany.removeAllItems();
			companybox();
			mp.setVisible(true);
			cp.setVisible(false);
			sp.setVisible(false);
			pp.setVisible(false);
			pwp.setVisible(false);
			up.setVisible(false);
			dp.setVisible(false);
			
						
		}
		else if(ae.getSource()==companies)
		{
			mp.setVisible(false);
			cp.setVisible(true);
			sp.setVisible(false);
			pp.setVisible(false);
			pwp.setVisible(false);
			up.setVisible(false);
			dp.setVisible(false);
			//jbutton -addc updct deletecomp
			
			addc.setVisible(true);
			updct.setVisible(true);
			deletecomp.setVisible(true);
		}
		else if(ae.getSource()==sale)
		{
			mp.setVisible(false);
			cp.setVisible(false);
			sp.setVisible(true);
			pp.setVisible(false);
			pwp.setVisible(false);
			up.setVisible(false);
			dp.setVisible(false);			
		}
		else if(ae.getSource()==addPro)
		{
			//nsnamet, nsquantityt	nsnamel,nsquantityl	nsaddb
			nsnamet.setVisible(true);
			nsquantityt.setVisible(true);
			nsnamel.setVisible(true);
			nsquantityl.setVisible(true);
			nsaddb.setVisible(true);
			
			mp.setVisible(false);
			cp.setVisible(false);
			sp.setVisible(false);
			pp.setVisible(true);
			pwp.setVisible(false);
			up.setVisible(false);
			dp.setVisible(false);
		}
		else if(ae.getSource()==cPass)
		{
			mp.setVisible(false);
			cp.setVisible(false);
			sp.setVisible(false);
			pp.setVisible(false);
			pwp.setVisible(true);
			up.setVisible(false);
			dp.setVisible(false);
		}
		else if(ae.getSource()==cUser)
		{
			mp.setVisible(false);
			cp.setVisible(false);
			sp.setVisible(false);
			pp.setVisible(false);
			pwp.setVisible(false);
			up.setVisible(true);
			dp.setVisible(false);
		}
		else if(ae.getSource()==dUser)
		{
			mp.setVisible(false);
			cp.setVisible(false);
			sp.setVisible(false);
			pwp.setVisible(false);
			up.setVisible(false);
			pp.setVisible(false);
			dp.setVisible(true);			
		}
		
		if(ae.getSource()==addc)
		{
		//label - cname lclocation lcemail lccontact	textfield - tcname tclocation tcemail tccontact 	Jbutton bcadd
			lcname.setVisible(true);
			lclocation.setVisible(true);
			lcemail.setVisible(true);
			lccontact.setVisible(true);
			tcname.setVisible(true);
			tclocation.setVisible(true);
			tcemail.setVisible(true);
			tccontact.setVisible(true);
			bcadd.setVisible(true);
			
			//Email- lupdemail tupdemail	contact- lupdcontact tupdcontact	bupdcontact
			ludpemail.setVisible(false);
			tupdemail.setVisible(false);
			lupdcontact.setVisible(false);
			tupdcontact.setVisible(false);
			bupdcontact.setVisible(false);
			ldeletec.setVisible(false);
			bdeletec.setVisible(false);
			tdeletec.setVisible(false);
			lupdname.setVisible(false);
			tcupdname.setVisible(false);
		}
		else if(ae.getSource()==updct)
		{
			ludpemail.setVisible(true);
			tupdemail.setVisible(true);
			lupdcontact.setVisible(true);
			tupdcontact.setVisible(true);
			bupdcontact.setVisible(true);
			lupdname.setVisible(true);
			tcupdname.setVisible(true);
			
			lcname.setVisible(false);
			lclocation.setVisible(false);
			lcemail.setVisible(false);
			lccontact.setVisible(false);
			tcname.setVisible(false);
			tclocation.setVisible(false);
			tcemail.setVisible(false);
			tccontact.setVisible(false);
			bcadd.setVisible(false);
			ldeletec.setVisible(false);
			bdeletec.setVisible(false);
			tdeletec.setVisible(false);
		}
		else if(ae.getSource()==deletecomp)
		{
			// ldeletec bdeletec tdeletec
			ldeletec.setVisible(true);
			bdeletec.setVisible(true);
			tdeletec.setVisible(true);
			
			lcname.setVisible(false);
			lclocation.setVisible(false);
			lcemail.setVisible(false);
			lccontact.setVisible(false);
			tcname.setVisible(false);
			tclocation.setVisible(false);
			tcemail.setVisible(false);
			tccontact.setVisible(false);
			bcadd.setVisible(false);
			ludpemail.setVisible(false);
			tupdemail.setVisible(false);
			lupdcontact.setVisible(false);
			tupdcontact.setVisible(false);
			bupdcontact.setVisible(false);
			lupdname.setVisible(false);
			tcupdname.setVisible(false);
			
		}
		
		if(ae.getSource()==bcadd)
		{
			addCompany();
		}
		
		if(ae.getSource()==bupdcontact)
		{
			updateContact();
		}
		if(ae.getSource()==update)
		{
			update.setVisible(false);
			addm.setVisible(true);
			upd_quant.setVisible(true);
			upd_price.setVisible(true);
			expired.setVisible(true);
									
		}
		if(ae.getSource()==bdeletec)
		{
			String name = tdeletec.getText();
			deleteCompany(name);
		}
		//nsnamet, nsquantityt		nsaddb nsremoveb
		if(ae.getSource()==nsaddb)
		{
			saleMed();		
		}
		if(ae.getSource()==nsremoveb)
		{
			removeMed();
		}
		
		if(ae.getSource()==cdiscount)
		{
			String dis = (String)cdiscount.getSelectedItem();
			String amt = tpayableamt.getText();
			double ammount = Double.parseDouble(amt);
			double discount = Double.parseDouble(dis);
			double newamt = ammount*((100-discount)/100);
			tpayableamt.setText(Double.toString(newamt));
		}
		
		if(ae.getSource()==jconfirm)
		{
			confirmBilling();
		}
		
		if(ae.getSource()==getsale)
		{
			displaySold();
		}
		//TextField old,nnew,conf	button updpassword
		if(ae.getSource()==updpassword)
		{
			String oldp=old.getText();
			String newwp=nnew.getText();
			String confp=conf.getText();
			if(oldp.isEmpty() || newwp.isEmpty() || confp.isEmpty())
			{
				JOptionPane.showMessageDialog (null,"Enter All Fields");
			}
			else if(!newwp.equals(confp))
			{
				JOptionPane.showMessageDialog (null,"New Password and confirm password not match");
			}
			else
			{
				String p=null;
				int count =0;
				try{				
					Connection con = ob.getConnection();
					String query = "select password from login where email=?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,username);
					ResultSet rs = pst.executeQuery();
					while(rs.next())
					{
						p=rs.getString("password");
						count++;
					}
					
					if(count==0)
					{
						JOptionPane.showMessageDialog (null,"Incorrect Old Password");
					}
					else
					{
						String cquery = "update login set password=? where email=?";
						PreparedStatement pstm = con.prepareStatement(cquery);
						pstm.setString(1,confp);
						pstm.setString(2,username);
						pstm.executeUpdate();
						JOptionPane.showMessageDialog (null,"Password Updated for username="+username);
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}				
			}
		}
		
		if(ae.getSource()==logout)
		{
			username=null;
			f.dispose();
			new LoginForm();
		}
		
		if(ae.getSource()==addm)
		{
			tmrp.setVisible(true);
			mrp.setVisible(true);
			mname.setVisible(true);
			medname.setVisible(true);
			company.setVisible(true);
			category.setVisible(true);
			Ccategory.setVisible(true);
			company.setVisible(true);
			Ccompany.setVisible(true);
			lquant.setVisible(true);
			tquant.setVisible(true);
			manu.setVisible(true);
			dmanu.setVisible(true);
			exp.setVisible(true);
			dexp.setVisible(true);
			badd.setVisible(true);
				
			lupn.setVisible(false);
			tupn.setVisible(false);
			lupq.setVisible(false);
			tupq.setVisible(false);
			bupq.setVisible(false);
			lupmrpn.setVisible(false);
			tupmrpn.setVisible(false);
			lupmrp.setVisible(false);
			tupmrp.setVisible(false);
			bupmrp.setVisible(false);
			sbe.setVisible(false);
			expd.setVisible(false);					
		}
		else if(ae.getSource()==upd_quant)	
		{
			lupn.setVisible(true);
			tupn.setVisible(true);
			lupq.setVisible(true);
			tupq.setVisible(true);
			bupq.setVisible(true);
			
			tmrp.setVisible(false);
			mrp.setVisible(false);
			mname.setVisible(false);
			medname.setVisible(false);
			company.setVisible(false);
			category.setVisible(false);
			Ccategory.setVisible(false);
			company.setVisible(false);
			Ccompany.setVisible(false);
			lquant.setVisible(false);
			tquant.setVisible(false);
			manu.setVisible(false);
			dmanu.setVisible(false);
			exp.setVisible(false);
			dexp.setVisible(false);
			badd.setVisible(false);
			lupmrpn.setVisible(false);
			tupmrpn.setVisible(false);
			lupmrp.setVisible(false);
			tupmrp.setVisible(false);
			bupmrp.setVisible(false);
			sbe.setVisible(false);
			expd.setVisible(false);
		}
		else if(ae.getSource()==upd_price)
		{
			lupmrpn.setVisible(true);
			tupmrpn.setVisible(true);
			lupmrp.setVisible(true);
			tupmrp.setVisible(true);
			bupmrp.setVisible(true);
			
			tmrp.setVisible(false);
			mrp.setVisible(false);
			mname.setVisible(false);
			medname.setVisible(false);
			company.setVisible(false);
			category.setVisible(false);
			Ccategory.setVisible(false);
			company.setVisible(false);
			Ccompany.setVisible(false);
			lquant.setVisible(false);
			tquant.setVisible(false);
			manu.setVisible(false);
			dmanu.setVisible(false);
			exp.setVisible(false);
			dexp.setVisible(false);
			badd.setVisible(false);			
			lupn.setVisible(false);
			tupn.setVisible(false);
			lupq.setVisible(false);
			tupq.setVisible(false);
			bupq.setVisible(false);
			sbe.setVisible(false);
			expd.setVisible(false);
		}
		else if(ae.getSource()==expired)
		{
			sbe.setVisible(true);
			expd.setVisible(true);
			
			tmrp.setVisible(false);
			mrp.setVisible(false);
			mname.setVisible(false);
			medname.setVisible(false);
			company.setVisible(false);
			category.setVisible(false);
			Ccategory.setVisible(false);
			company.setVisible(false);
			Ccompany.setVisible(false);
			lquant.setVisible(false);
			tquant.setVisible(false);
			manu.setVisible(false);
			dmanu.setVisible(false);
			exp.setVisible(false);
			dexp.setVisible(false);
			badd.setVisible(false);
			lupn.setVisible(false);
			tupn.setVisible(false);
			lupq.setVisible(false);
			tupq.setVisible(false);
			bupq.setVisible(false);
			lupmrpn.setVisible(false);
			tupmrpn.setVisible(false);
			lupmrp.setVisible(false);
			tupmrp.setVisible(false);
			bupmrp.setVisible(false);
			getExpired();
		}
		
		if(ae.getSource()==searchb)
		{
		try{
			String searchStr = searcht.getText();
			Connection con = ob.getConnection();
			String searchrs = "select mid,name,price,quantity,category,expiry from medicines where name=?";
			PreparedStatement p = con.prepareStatement(searchrs);
			p.setString(1,searchStr);
			ResultSet rs=p.executeQuery();
			model.setRowCount(0);
			if (rs.next())
			{
		        	int seid = rs.getInt("mid");
		        	String sename = rs.getString("name");
		        	int seprice = rs.getInt("price");
		        	int sequantity = rs.getInt("quantity");
		        	String secategory = rs.getString("category");
		        	String seexpiry = rs.getString("expiry");
		        	model.addRow(new Object[]{seid,sename,seprice,sequantity,secategory,seexpiry});
		    	}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
		}
		
		//Jtable cst DefaultTableModel cmodel scrollpane csb
		if(ae.getSource()==bcsearch)
		{
		try{
			String searchStr = tcsearch.getText();
			Connection con = ob.getConnection();
			String searchrs = "select cid,cname,location,email,contact from company where cname=?";
			PreparedStatement p = con.prepareStatement(searchrs);
			p.setString(1,searchStr);
			ResultSet rs=p.executeQuery();
			cmodel.setRowCount(0);
			if (rs.next())
			{
		        	int ceid = rs.getInt("cid");
		        	String cename = rs.getString("cname");
		        	String celocation = rs.getString("location");
		        	String cemail = rs.getString("email");
		        	long ccontact = rs.getLong("contact");
		        	cmodel.addRow(new Object[]{ceid,cename,celocation,cemail,ccontact});
		    	}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught-"+e);
		}
		}
		
		if(ae.getSource()==expd)
		{
			deleteExp();
		}
		if(ae.getSource()==bupmrp)
		{
			//text-tupmrpn,tupmrp	button-bupmrp	label- lupmrp, lupmrpn
			String mp = tupmrp.getText();
			String medn = tupmrpn.getText();
			updatePrice(medn,mp);
		}
		
		if(ae.getSource()==bupq)
		{
			//tupq tupn
			String mq = tupq.getText();
			String mn = tupn.getText();
			updateQuantity(mn,mq);
		}
			
		if(ae.getSource()==badd)
		{
			//searcht,medname,tmrp,tquant,dmanu,dexp;
			String mename = medname.getText();  
			String medprice = tmrp.getText();
			String quantity = tquant.getText();
			String medman = dmanu.getText();
			String medexp = dexp.getText();
		if(mename.isEmpty() || medprice.isEmpty() || quantity.isEmpty() || medman.isEmpty() || medexp.isEmpty()) 
		{
			JOptionPane.showMessageDialog (null, "All Fields Are Compulsory");
		}
		else {
			if(!isNumber(medprice) || !isNumber(quantity) || !isDate(medman) || !isDate(medexp))
			{
				JOptionPane.showMessageDialog (null, "Invalid Date, price or quanity");
			}
			else if(!vman(medman))
			{
				JOptionPane.showMessageDialog (null, "Invalid Manufacture Date");
			}
			else if(vman(medman) && vmann(medman,medexp))
			{
				Connection con = ob.getConnection();
				String co = (String)Ccompany.getSelectedItem();
				String ct = Ccategory.getSelectedItem().toString();
				try{
					int coid=0;
					String getid = "Select cid from company where cname=?";
					PreparedStatement pstmt = con.prepareStatement(getid);
					pstmt.setString(1,co);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						coid = rs.getInt("cid");	
					}
					
	String q = "insert into medicines(name,price,quantity,category,expiry,manufacture,cid) values(?,?,?,?,?,?,?)";
						PreparedStatement pst = con.prepareStatement(q);
						int p=Integer.parseInt(medprice);  
						int quanti=Integer.parseInt(quantity);  
						  
						pst = con.prepareStatement(q);
						pst.setString(1,mename);
						pst.setInt(2,p);
						pst.setInt(3,quanti);
						pst.setString(4,ct);
						pst.setString(5,medexp);
						pst.setString(6,medman);
						pst.setInt(7,coid);
						pst.executeUpdate();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
					JOptionPane.showMessageDialog (null, mename+" added successfully");
			}
			
		}
		}   		
	}	
}


/*Medical store Management System created using Java(AWT & Swing) gives a better and smooth way to manage medical store no matter medical shop is small or big. This project is made by keeping some important and basic functionalities into consideration. As Admin has some special access like to remove or add an employee to shop, get sales record of past days, months or years and also admin can act as a common employee by selling goods.
To make the process smooth and simple proper error messages can help users to identify what's going wrong.
Some of the features are not currently implemented as they are not so important seeing the current situation.*/
