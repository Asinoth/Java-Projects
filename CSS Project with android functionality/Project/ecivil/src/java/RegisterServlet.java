import ecivil.core.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    
    String sex,email,pwd,pwdconf,mobilenum,homenum,name,surname,Country,town,job,homeaddress;
    String blood,moreinfo,certifications,volunteer,organization,volunteerwant,bday;
    String carlicen,boatlicen,bikelicen,trucklicen;
    String cartrans,boattrans,biketrans,trucktrans;
    String facebook, skype, gmail;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    
    sex=request.getParameter("sex");
    email=request.getParameter("email");
    pwd=request.getParameter("pwd");
    pwdconf=request.getParameter("pwdconf");
    mobilenum=request.getParameter("mobilenum");
    homenum=request.getParameter("homenum");
    name=request.getParameter("name");
    surname=request.getParameter("surname");
    Country=request.getParameter("Country");
    town=request.getParameter("town");
    job=request.getParameter("job");
    homeaddress=request.getParameter("homeaddress");
    blood=request.getParameter("blood");
    moreinfo=request.getParameter("moreinfo");
    
    certifications=request.getParameter("certifications");
    volunteer=request.getParameter("volunteer");
    bday=request.getParameter("bday");    
    carlicen=request.getParameter("carlicen");
    boatlicen=request.getParameter("boatlicen");
    bikelicen=request.getParameter("bikelicen");
    trucklicen=request.getParameter("trucklicen");
    cartrans=request.getParameter("cartrans");
    boattrans=request.getParameter("boattrans");
    biketrans=request.getParameter("biketrans");
    trucktrans=request.getParameter("trucktrans");
    facebook=request.getParameter("facebook");
    skype=request.getParameter("skype");
    gmail=request.getParameter("gmail");    
    organization=request.getParameter("organization");
    volunteerwant=request.getParameter("volunteerwant");
    
    //non required info
    if("".equals(homenum)){
        homenum="+00-0000000000";
    }
    if("".equals(job)){
        job="N/A";
    }
    if("".equals(homeaddress)){
        homeaddress="N/A";
    }
    if("".equals(moreinfo)){
        moreinfo="N/A";
    }
    if("".equals(certifications)){
        certifications="N/A";
    }
    if("".equals(organization)){
        organization="N/A";
    }
    if("".equals(skype)){
        skype="N/A";
    }
    if("".equals(facebook)){
        facebook="N/A";
    }
    if("".equals(gmail)){
        gmail="N/A";
    }
    
    /* Server-side checks
     * PasswordConfirmation
     * Age Check (must be >15)
     * Email Check (nobody must have the same mail)
    */
    
    //PasswordConfirmation
    if(pwd.compareTo(pwdconf)==0){
        //pwd and pwdconf are the same,so confirmation passed
    }
    else{//Error re fill new form without email and passwords
        PrintForm(out);
        return;
    }
    
    //Age Check
    Calendar now = Calendar.getInstance();   // This gets the current date and time.
    int year = Integer.parseInt(bday.split("-")[0]);
    int curyear = now.get(Calendar.YEAR);
    if(year <= (curyear-15)){
            //ok. Check Passed
        }
    else{
            //ERROR. User age less than 15 So he goes back to Main.html
            out.println("<html>\n" +
                        "<!-- Author name: Kutsukos Giannis  AM:2609 -->\n" +
                        "<body style=\"height: 100%; width: 100%; background-color:#FFA500;\">\n" +
                        "<script>\n" +
                        "	setInterval(function(){window.location.href = \"index.jsp\";},500);"+
                        "	</script>\n" +
                        "</body>\n" +
                        "</html>");
        }
    //Save Info for ID: email
    Member newmember;
        newmember = new Member(0, sex, email, pwd, mobilenum, homenum, name, surname, Country, town, job, homeaddress, blood, moreinfo, pwd, certifications, volunteer, organization, volunteerwant, bday, carlicen, boatlicen, bikelicen, trucklicen, cartrans, boattrans, biketrans, trucktrans, facebook, skype, gmail, " ");
        
        
        try {        
            newmember.addInDatabase();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintInfo(out);
        //* Profile Photo NOW!! (must be <2mb)
    out.println(
                        "<h1>Registration Successful</h1>"
            + "<h2>Change profile foto?</h2> \n"
            +           "<img src=\"icons/default_profile_pic.png\" alt=\"some_text\" border=\"3\"><br>\n"+
                        "<form name=\"PhotoUpload\" action=\"Upload\" method=\"post\"enctype=\"multipart/form-data\">"
            + "<input type=\"file\" name=\"pic\" id=\"pic\"> pic size&lt;2mb<br>\n"
            + "<input type=\"submit\" name=\"submit\" value=\"Upload\"><input type=\"button\" name=\"Skip\" value=\"Skip\" onclick=\"skip();\"></form>"+
                        "</body>\n" +
                        "</html>");
    
    }
     
  public void uploadPic(){
      
  }

    
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  
  private void PrintForm(PrintWriter out){
       out.println("<html>\n" +
                    "<!-- Author name: Kutsukos Giannis  AM:2609 -->\n" +
                    "<head>\n" +
                    "    <title> Register User</title>\n" +
                    "    <script>\n" +
                    "		var i=0;\n" +
                    "		function Volyes(){\n" +
                    "                        \n" +
                    "			if(i===0){\n" +
                    "                            i=1;\n" +
                    "				var volunteerinfo =document.getElementById(\"volunteerinfo\");\n" +
                    "				volunteerinfo.innerHTML+=\"Already belong to the organization / volunteer group: <input type=text name=organization maxlength=50><br><input type=checkbox name=volunteerwant value=Yes>I do not belong, but I'd like\";\n" +
                    "			}\n" +
                    "		}\n" +
                    "                function Volno(){\n" +
                    "			if(i===1){\n" +
                    "				i=0;\n" +
                    "				var volunteerinfo =document.getElementById(\"volunteerinfo\");\n" +
                    "				volunteerinfo.innerHTML=\" \";\n" +
                    "			}\n" +
                    "		}\n" +
                    "	</script>\n" +
                    "</head>\n" +
                    "<body style=\"height: 100%; width: 100%; background-color:#FFA500;\">\n" +
                    "    <div style=\"color:#0000FF;\">\n" +
                    "        <h1><b>Register Form</b></h1><br>\n" +
                    "        <b>Invalid Information! Please fill blank areas</b>"+
                    "        <form action=\"RegisterServlet\" autocomplete=\"off\" method=\"POST\">\n" +
                    "            E-mail: <input type=\"email\" value="+email+" name=\"email\" autocomplete=\"off\" pattern=\"^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$\" required><br>            \n" +
                    "            Password: <input id=\"password\" name=\"pwd\" type=\"password\" pattern=\"^(?=[a-zA-Z])(?=.*[0-9])(?=.*[#\\$_])(?!.*[^a-zA-Z0-9#\\$_])(?!.*\\s).{6,12}$\" title=\"Min 6 Max 12 letters and numbers and symbols required\" required><br>\n" +
                    "            Password Confirmation: <input type=\"password\" name=\"pwdconf\" pattern=\"^(?=[a-zA-Z])(?=.*[0-9])(?=.*[#\\$_])(?!.*[^a-zA-Z0-9#\\$_])(?!.*\\s).{6,12}$\" title=\"Min 6 Max 12 letters and numbers and symbols required\" required><br>\n" +
                    "            Mobile Number: <input type=\"tel\" value="+mobilenum+" pattern=\"[\\+]\\d{2}[\\-]\\d{10}\" name=\"mobilenum\" required/> (format: \"+Country_Calling_Code - xxxxxxxxxx\" example: +30-2107648321)<br>\n" +
                    "            Home Number: <input type=\"tel\" value="+homenum+" pattern=\"[\\+]\\d{2}[\\-]\\d{10}\" name=\"homenum\" /> (format: \"+Country_Calling_Code - xxxxxxxxxx\")<br>\n" +
                    "            Name: <input type=\"text\" name=\"name\" value="+name+" maxlength=\"20\" required><br>\n" +
                    "            Surname: <input type=\"text\" name=\"surname\" value="+surname+" maxlength=\"30\" required><br>\n" +
                    "            Birthday: <input type=\"date\" value="+bday+" name=\"bday\" required><br> \n" +
                    "            Gender: \n");
                        
       
                        if("male".equals(sex)){
                            out.println(
                    "                <input type=\"radio\" name=\"sex\" checked value=\"male\">Male\n " +
                    "                <input type=\"radio\" name=\"sex\" value=\"female\">Female\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"neither\">Neither of them\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"both\">Both of them\n" +
                    "            <br>\n");
                        }
                        else if("female".equals(sex)){
                            out.println(
                    "                <input type=\"radio\" name=\"sex\" value=\"male\">Male\n " +
                    "                <input type=\"radio\" checked name=\"sex\" value=\"female\">Female\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"neither\">Neither of them\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"both\">Both of them\n" +
                    "            <br>\n");
                        }
                        else if("neither".equals(sex)){
                            out.println(
                    "                <input type=\"radio\" name=\"sex\" value=\"male\">Male\n " +
                    "                <input type=\"radio\" name=\"sex\" value=\"female\">Female\n" +
                    "                <input type=\"radio\" name=\"sex\" checked value=\"neither\">Neither of them\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"both\">Both of them\n" +
                    "            <br>\n");
                        }
                        else{
                            out.println(
                    "                <input type=\"radio\" name=\"sex\" value=\"male\">Male\n " +
                    "                <input type=\"radio\" name=\"sex\" value=\"female\">Female\n" +
                    "                <input type=\"radio\" name=\"sex\" value=\"neither\">Neither of them\n" +
                    "                <input type=\"radio\" name=\"sex\" checked value=\"both\">Both of them\n" +
                    "            <br>\n");
                        }
                        out.println(
                    "            Country: <select name=\"Country\"> \n" +
                    "                <option value="+Country+">"+Country+"</option>\n"+
                    "                </select><br>\n" +
                    "            Town: <input type=\"text\" value="+town+" name=\"town\" pattern=\"[a-zA-Z]{2,50}\" required><br>\n" +
                    "            Job: <input type=\"text\" value="+job+" name=\"job\" maxlength=\"50\"><br>\n" +
                    "            Home address: <input type=\"text\" value="+homeaddress+" name=\"homeaddress\" maxlength=\"50\"><br>\n");
                        if("Car".equals(carlicen)){
                            out.println(
                                "            Driving licenses: <input type=\"checkbox\" name=\"carlicen\" checked value=\"Car\">Car\n");
                        }
                        else{
                            out.println(
                                "            Driving licenses: <input type=\"checkbox\" name=\"carlicen\" value=\"Car\">Car\n");
                        }
                        if("Bike".equals(bikelicen)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"bikelicen\" checked value=\"Bike\">Bike\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"bikelicen\" value=\"Bike\">Bike\n");
                        }
                        if("Truck".equals(trucklicen)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"trucklicen\" checked value=\"Truck\">Truck\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"trucklicen\" value=\"Truck\">Truck\n");
                        }
                        if("Boat".equals(boatlicen)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"boatlicen\" checked value=\"Boat\">Boat<br>\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"boatlicen\" value=\"Boat\">Boat<br>\n");
                        }
                        
                        //Transportation
                        if("Car".equals(cartrans)){
                            out.println(
                                "            Transportation: <input type=\"checkbox\" name=\"cartrans\" checked value=\"Car\">Car\n");
                        }
                        else{
                            out.println(
                                "            Transportation: <input type=\"checkbox\" name=\"cartrans\" value=\"Car\">Car\n");
                        }
                        if("Bike".equals(biketrans)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"biketrans\" checked value=\"Bike\">Bike\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"biketrans\" value=\"Bike\">Bike\n");
                        }
                        if("Truck".equals(trucktrans)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"trucktrans\" checked value=\"Truck\">Truck\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"trucktrans\" value=\"Truck\">Truck\n");
                        }
                        if("Boat".equals(boattrans)){
                            out.println(
                                "            <input type=\"checkbox\" name=\"boattrans\" checked value=\"Boat\">Boat<br>\n");
                        }
                        else{
                            out.println(
                                "            <input type=\"checkbox\" name=\"boattrans\" value=\"Boat\">Boat<br>\n");
                        }
                        
                        
                        
                        
                        out.println(
               
                    "            Blood Type: <select name=\"blood\"> \n" +
                    "                            <option value="+blood+">"+blood+"</option>\n"+
                    "                        </select><br>\n" +
                    "            More info: <input type=\"text\" value="+moreinfo+" name=\"moreinfo\" maxlength=\"500\"><br>\n" +
                    "            Certifications: <input type=\"text\" value="+certifications+" name=\"certifications\" maxlength=\"100\"><br>\n");
                        if("yes".equals(volunteer)){
                            out.println("Already belong to the organization / volunteer group: <input type=text name=organization value="+organization+" maxlength=50><br>");
                            if("yes".equals(volunteerwant)){
                                out.println("<input type=checkbox name=volunteerwant checked value=Yes>I do not belong, but I'd like<br>");
                            }
                            else{
                                out.println("<input type=checkbox name=volunteerwant value=Yes>I do not belong, but I'd like<br>");
                            }
                        }
                        else{
                            out.println(
                    "            I am an active member (certified volunteer) or want to be: \n" +
                    "                            <input type=\"radio\" onclick=\"Volyes();\" name=\"volunteer\" value=\"yes\">Yes\n" +
                    "                            <input type=\"radio\" onclick=\"Volno();\" name=\"volunteer\" value=\"no\">No\n" +
                    "                            <input type=\"radio\" checked name=\"volunteer\" value=\"N/A\">N/A\n" +
                    "            <div id=\"volunteerinfo\"> </div><br>\n");
                            }
                        out.println(
                    "            Social Networks: <ul><li>Facebook<input type=\"text\" value="+facebook+" name=\"facebook\" maxlength=\"50\"></li>\n" +
                    "                                <li>SkypeID<input type=\"text\" value="+skype+" name=\"skype\" maxlength=\"50\"></li>\n" +
                    "                                <li>Gmail/GTalkID<input type=\"text\" value="+gmail+" name=\"gmail\" maxlength=\"50\"></li></ul>\n" +
                    "            \n" +
                    "            <br><INPUT TYPE=\"SUBMIT\" NAME=\"previewButton\" Value=\"Register\">\n" +
                    "\n" +
                    "          </form>\n" +
                    "\n" +
                    "        \n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
  }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void PrintInfo(PrintWriter out) {
        out.println("<html>\n" +
                    "<!-- Author name: Kutsukos Giannis  AM:2609 -->\n" +
                    "<head>\n" +
                    "    <title> New User Information</title>\n"+
                    "<script> "
                        + "function skip(){//go to main menu \n setInterval(function(){window.location.href = \"menu.html\";},500);}"
                        + "</script>"+
                    "</head>\n" +
                    "<body style=\"height: 100%; width: 100%; background-color:#FFA500;\">\n" +
                    "    <div style=\"color:#0000FF;\">\n" +
                    "            E-mail: " +email+"<br>\n"+
                    "            Password: "+pwd+"<br>\n"+
                    "            Password Confirmation: "+pwdconf+"<br>\n"+
                    "            Mobile Number: "+mobilenum+"<br>\n"+
                    "            Home Number: "+homenum+"<br>\n"+
                    "            Name: "+name+"<br>\n"+
                    "            Surname: "+surname+"<br>\n"+
                    "            Birthday: "+bday+"<br>\n"+
                    "            Gender: "+sex+"<br>\n"+
                    "            Country: "+Country+"<br>\n"+
                    "            Town: "+town+"<br>\n"+
                    "            Job: "+job+"<br>\n"+
                    "            Home address: "+homeaddress+"<br>\n");
                        if("Car".equals(carlicen)){
                            out.println(
                                "            Driving licenses: "+carlicen+"<br>\n");
                        }
                        
                        if("Bike".equals(bikelicen)){
                            out.println(
                                "            Driving licenses: "+bikelicen+"<br>\n");
                        }
                        
                        if("Truck".equals(trucklicen)){
                            out.println(
                                "            Driving licenses: "+trucklicen+"<br>\n");
                        }
                        
                        if("Boat".equals(boatlicen)){
                            out.println(
                                "            Driving licenses: "+boatlicen+"<br>\n");
                        }
                        
                        
                        //Transportation
                        if("Car".equals(cartrans)){
                            out.println(
                                "            Transportation: "+cartrans+"<br>\n");
                        }
                        
                        if("Bike".equals(biketrans)){
                            out.println(
                                "            Transportation: "+biketrans+"<br>\n");
                        }
                        
                        if("Truck".equals(trucktrans)){
                            out.println(
                                "            Transportation: "+trucktrans+"<br>\n");
                        }
                        
                        if("Boat".equals(boattrans)){
                            out.println(
                                "            Transportation: "+boattrans+"<br>\n");
                        }
                        
                        
                        
                        
                        
                        out.println(
               
                    "            Blood Type: "+blood+"<br>\n"+
                    "            More info: "+moreinfo+"<br>\n"+
                    "            Certifications: "+certifications+"<br>\n"
                                + "Volunteer: "+volunteer+"<br>\n"
                                + "Organization: "+organization+"<br>\n"
                                + "VolunteerWant: "+volunteerwant+"<br>\n"
                                + "Facebook: "+facebook+"<br>\n"
                                + "Skype: "+skype+"<br>\n"
                                + "Gmail: "+gmail+"<br>\n"+
                                "    </div>\n" +
                    "</body>\n" +
                    "</html>"                   );
                        
                                
                            
                        
                        
                       
    }
}