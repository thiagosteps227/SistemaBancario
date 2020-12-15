<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Sistema Bancário</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                   
				<h2>Sistema Bancário</h2>
                    <!--  <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list">Usuários</a></li>
                    </ul>-->
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de Contas</h3>
                    <hr>
                    
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Número</th>
                                <th>Agência</th>
                                <th>Tipo de Conta</th>
                                <th>Limite</th>
                                <th>Limite do Cartão</th>
                                <th>Nome do titular</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                           
                            <c:forEach var="conta" items="${listConta}">

                                <tr>
                                    <td>
                                        <c:out value="${conta.numero}" />
                                    </td>
                                    <td>
                                        <c:out value="${conta.agencia}" />
                                    </td>
                                    <td>
                                        <c:out value="${conta.tipoConta}" />
                                    </td>
                                    <td>
                                        <c:out value="${conta.limite}" />
                                    </td>
                                    <td>
                                        <c:out value="${conta.cartao}" />
                                    </td>
                                    <td>
                                        <c:out value="${conta.nomeTitular}" />
                                    </td>
                                   
                                </tr>
                            </c:forEach>
                            
                        </tbody>

                    </table>
                    <form action="index.jsp" method="get">
						<input type="submit" value="Voltar"/>
					</form>
                </div>
            </div>
        </body>

        </html>