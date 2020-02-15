<%-- 
    Document   : index
    Created on : 15/02/2020, 13:26:39
    Author     : Aluno 04
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de estoque</title>
    </head>
    <body>
        <h1>Controle de estoque de uma loja</h1>
        
        <form method="POST" action="login">
            <p>
                <label>Digite o nome da loja:</label>
                <input type="text" name ="nomeDaLoja"/>
            </p>
            <p>
                <input type="submit" value="Entrar" />
            </p>
            <br><br>
        </form>
        <button id="info" onclick= "mostrarInformacoes();">mostrar informações</button>
        
        <script>
            function mostrarInformacoes(){
                
            }
            
            
            
            
            
            </script>
    </body>
</html>
