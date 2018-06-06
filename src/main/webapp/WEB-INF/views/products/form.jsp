<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cadastro de Livro</title>
</head>
<body>
	<form method="post" action="/casadocodigo/produtos">
		<div>
			<label for="title">Titulo</label>
			<input type="text" name="title" id="title" />
		</div>
	
		<div>
			<label for="description">Descrição</label>
			<textarea rows="10" cols="20" name="description" id="description"></textarea>
		</div>
		
		<div>
			<label for="pages">Numero de Paginas</label>
			<input type="text" name="pages" id="pages" />
		</div>
		
		<div>
			<input type="submit" value="Enviar" />
		</div>
	</form>
</body>
</html>