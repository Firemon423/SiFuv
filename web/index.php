<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    
    <h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title><ui:insert name="title">Inicio - SiFuv</ui:insert></title>
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
        <h:outputStylesheet name="css/boostrap.css"/>
        <h:outputStylesheet name="css/inicio.css"/>
    </h:head>

    <h:body>  
            <header id="header">

     <!-- Navegation Menu -->
     <nav class="menu">
         <div class="logobox">
             <h1 class="logo"><a href="#">
                <i class="fas fa-apple-alt"></i>
                SiFuv
             </a></h1>

             <span class="btn-menu"><i class="fas fa-apple-alt"></i></span>
         </div>

         <div class="list-container">
             <ul class="lists">
                 <li><a href="#" class="active"></a></li>
                 <li><a href="faces/IniciosSesion.xhtml">Inicio Sesión</a></li>
                 <li><a href="faces/cliente/Create.xhtml">Registrate</a></li>
             </ul>
         </div>
     </nav>

     <!-- Img Header -->
     <figure class="img-header">
         <div class="welcome">
            <h4>"Disfruta De Unas Frutas y Vegetales Frescos"</h4>
            <h2><a href="#">
               
               Fruver La Victoria
            </a></h2>
         </div>
     </figure>

    </header>
        
<main>
    
    <!-- About Us -->
    <section class="about-us">
        <div class="info">
            <h3>Acerca de nosotros</h3>
            <p>Somos una empresa que desea expandir sus productos a nivel nacional creando el mayor impacto por medio de nuestros domicilios y alimento de exelente calidad, teniendo un incentivo para nuestros cliente por medio de nuestros descuentos.</p>
            <hr/>
        </div>

        <div class="free-content">
            <h4>¿Donde Nos Encontramos y Como nos Contactas?</h4>
            <div class="icons">
                <div>
                    <div class="span-icon"><i class="far fa-route"></i></div>
                    <h6>Direccion</h6>
                    <p>Crr 4#36k 28 sur.</p>
                 </div>

                 <div>
                    <div class="span-icon"><span><i class="far fa-phone-rotary"></i></span></div>
                    <h6>Contacto</h6>
                    <p>4725702-3007736402.</p>
                 </div>
                 <div>
                    <div class="span-icon"><span><i class="fal fa-biking-mountain"></i></span></div>
                    <h6>Domicilios</h6>
                    <p>Solo para la localidad de San Cristobal.</p>
                 </div>
                
            </div>
        </div>
    </section>

    <!-- Gallery -->
    <section class="gallery-section">
       
           
        

        <div class="gallery-content">
            <div class="img-card"><img src="resources/img/imagen1.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen2.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen3.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen4.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen5.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen6.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen7.jpg" alt="Frutas"/></div>
            <div class="img-card"><img src="resources/img/imagen8.jpg" alt="Frutas"/></div>
            
        </div>

        <!-- Modal -->
         <div class="modal">
             <span id="closeModal"><i class="fas fa-times"></i></span>
             <img id="imgModal"/>
             <p id="caption"></p>
         </div>

    </section>
   
    <!-- Footer -->
    <footer>
       <p>&copy; Todos los derechos reservados - 2020 | SiFuv</p>
    </footer>

</main>
<script src="https://kit.fontawesome.com/35db202371.js" crossorigin="anonymous"></script>
<script src="js/jquery.js"></script>
    </h:body>

</html>

