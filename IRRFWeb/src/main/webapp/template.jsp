<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en"> 
    <head> 
        <meta charset="utf-8" />  
        <!-- Change for better search engine indexing -->  
        <title>IRRF</title>  
        <meta name="title" content="Web site" />  
        <meta name="description" content="Your Web site description here" />  
        <meta name="keywords" content="Your Web site keywords here" />  
        <meta name="subject" content="Your Web Site subject here" />  
        <meta name="copyright" content="Your company or organization" />  
        <meta name="robots" content="All" />  
        <meta name="abstract" content="Site description here" />  
        <meta name="MSSmartTagsPreventParsing" content="true" />  
        <link id="theme" rel="stylesheet" type="text/css" href="style.css" title="theme" />  
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300|Roboto+Condensed|Roboto+Condensed:300|Roboto+Condensed:300|Roboto+Condensed:300|Roboto+Condensed:300" type="text/css" />  
        <script type="text/javascript" language="javascript" src="js/jquery-1.8.1.min.js"></script>  
        <script type="text/javascript" language="javascript" src="js/jquery.maskMoney.js"></script>
        <script type="text/javascript" language="javascript" src="js/scripts.js"></script>  
        <script type="text/javascript" language="javascript" src="js/theme.js"></script>  
        <script type="text/javascript" language="javascript" src="js/custom.js"></script>  
        <!-- Add your custom script here --> 
    </head>  
    <body> 
        <header> 
            <div id="top"> 
                <div class="bg"></div>  
                <div class="row"> 
                    <div id="logo"></div>  
                    <nav> 
                        <div id="hmenu"> 
                            <ul> 
                                <li> 
                                    <a href="irrf">HOME</a> 
                                </li>  
                                
                            </ul> 
                        </div> 
                    </nav>  
                    <div class="clear"></div> 
                </div> 
            </div>  
            <div id="header-wrapper"> 
                <div class="bg"></div>  
                <div class="row"> 
                    <div id="header"> 
                        <div id="tagline"> 
                            <h1>IRRF</h1>  
                            <!--<input type="button" class="cta pie" value="LEARN WHY..." />--> 
                        </div> 
                    </div> 
                </div> 
            </div> 
        </header>  
        <div id="wrapper"> 
            <div class="bg"></div>  
            <div class="row"> 
                <div id="container"> 
                    <div id="page"> 
                        <div id="main"> 
                            <section class="home"> 
                                <!-- REMOVE THIS -->  
                                <div style="text-align:center">
                                    <c:if test="${param.page != null}">
                                        <jsp:include page="${param.page}.jsp" />
                                    </c:if>
                                   
                                    <c:if test="${param.page == null}">
                                        <jsp:include page="index.jsp" />
                                    </c:if>
                                    
                                </div>  

                            </section> 
                        </div>  
                        <div class="clear" style="height:60px"></div> 
                    </div> 
                </div> 
            </div> 
        </div>  
<!--        <footer id="footer"> 
            <div class="bg"></div>  
            <div class="content"> 
                <div class="group"> 
                    <div class="col span_1_of_3"> 
                        <h2>Links</h2>  
                        <div class="vmenu"> 
                            <ul> 
                                <li>
                                    <a href="index.jsp">Home</a>
                                </li>  
                                <li>
                                    <a href="#">Fase 1</a>
                                </li>  
                            </ul> 
                        </div> 
                    </div>  
                    <div class="col span_1_of_3"> 
                        <h2>Sobre</h2>  
                        <p>Trabalho de Segurança da Informação.</p> 
                    </div>  
                    <div class="col span_1_of_3"> 
                        <h2>Contato</h2>  
                        <p>Daves Martins
                            <br /> 10 Somewhere Street, WWW Design City
                            <br /> 
                        </p> 
                    </div> 
                </div>  
                <div class="clear"></div>  

            </div> 
        </footer> -->
    </body> 
</html>
