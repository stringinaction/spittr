<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spittr (id=${spittleId})</h1>
        <a href="/homepage"><-gohome</a>
        <hr>
        <pre>
    @RequestMapping(value="/spittle/{spittleId}", method=GET)
    public String spittle_show(@PathVariable long spittleId, Model model){
        model.addAttribute("spittle", this.spittleRepository.findOne(spittleId));
        model.addAttribute(spittleId);
        return "spittle_show";
    }
        </pre>
        <hr>
        <li>
            ${spittle.message} | ${spittle.time}
        </li>
    </body>
</html>
