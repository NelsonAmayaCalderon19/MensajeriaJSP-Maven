<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>HTML5 y CSS Formulario de Contacto</title>
<link href="css/estilos.css" rel="stylesheet">
    </head>
    <body>
     <div class="container">
          <form class="contact_form" action="Control?menu=Mensaje" method="POST" id="data" >
<div>
<ul>
<li>
<h2>Contactos</h2>
<span class="required_notification">* Datos requeridos</span>
</li>
<li>
<label for="name">Id:</label>
<input type="text" name="id" value="${mensaje.getId()}" placeholder="1"  /><input type="submit"  name="accion" value="Buscar" class="btn btn-success">
</li>
<li>
<label for="name">Nombre:</label>
<input type="text" name="nombre" value="${mensaje.getNombre()}" placeholder="Nelson Amaya Calderon"  />
</li>
<li>
<label for="email">Email:</label>
<input type="email" name="email" value="${mensaje.getEmail()}" placeholder="ejemplo@algo.com"  />
<span class="form_hint">Formato correcto: "nombre@algo.com"</span>
</li>
<li>
<label for="website">Sitio web:</label>
<input type="url" name="website" value="${mensaje.getSitio()}" placeholder="http://loquesea.com"  pattern="(http|https)://.+" />
<span class="form_hint">Formato correcto: "http://algo.com"</span>
</li>
<li>
<label for="message">Mensaje:</label>
<textarea name="message" cols="40" rows="6" >${mensaje.getMensaje()}</textarea>
</li>
<li>
     <input  type="submit"  name="accion" value="Enviar" class="btn btn-info">
     
     <input type="submit"  name="accion" value="Eliminar" class="btn btn-danger"> 
     <input type="submit"  name="accion" value="Actualizar" class="btn btn-warning">       

</li>
</ul>
</div>
</form>
      </div>
      
</body>
</html>