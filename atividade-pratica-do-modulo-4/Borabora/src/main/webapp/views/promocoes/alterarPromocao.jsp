<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./css/style-admin.css" />
<title>Bora Bora Viagens - Alteração da promoção
	${promocao.destino}</title>
</head>

<body>
	<header>
		<div class="container">
			<!-- Início da navbar -->
			<nav class="navbar navbar-expand-lg">
				<div class="container-fluid">
					<img src="./img/logo-bora-bora-small.png" alt="" />
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav ms-auto">
							<li class="nav-item"><a class="nav-link"
								href="./cadastro-promocao">Cadastro de Promoções</a></li>
							<li class="nav-item"><a class="nav-link"
								href="./views/admin/admin.html">Sair</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Fim da navbar -->
		</div>
		<hr />
	</header>
	<main>
		<div class="container">
			<!-- Início do jumbotron -->
			<div class="mt-4 p-5 bg-secondary text-white rounded">
				<h1>Painel Administrador</h1>
			</div>
			<!-- Fim do jumbotron -->
			<!-- Início do CRUD -->
			<h3 style="margin-top: 10px">
				<a class="btn btn-warning" href="./cadastro-promocao" role="button">Voltar</a>
				Alteração da promoção ${promocao.destino}
			</h3>
			<form action="editar-promocao" method="post" class="form-control">

				<input type="hidden" name="id" value="${promocao.id}">
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Destino:</span>
					<input type="text" maxlength="50" name="destino" value="${promocao.destino}"
						class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Ida:</span>
					<input type="date" name="data_ida" value="${promocao.data_ida}"
						class="form-control" required /> <span
						class="input-group-text bg-secondary text-light">Horário:</span> <input
						type="time" name="horario_ida" value="${promocao.horario_ida}"
						class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Volta:</span>
					<input type="date" name="data_volta" value="${promocao.data_volta}"
						class="form-control" required /> <span
						class="input-group-text bg-secondary text-light">Horário:</span> <input
						type="time" name="horario_volta" value="${promocao.horario_volta}"
						class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Cia
						Aérea:</span> <input type="text" maxlength="50" name="cia_aerea"
						value="${promocao.cia_aerea}" class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Hotel:</span>
					<input type="text" maxlength="50" name="hotel" value="${promocao.hotel}"
						class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Observações:</span>
					<input type="text" maxlength="100" name="observacoes"
						value="${promocao.observacoes}" class="form-control" required />
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text bg-secondary text-light">Valor:</span>
					<input type="number" name="valor" value="${promocao.valor}"
						class="form-control" required /> <span
						class="input-group-text bg-secondary text-light">Valor
						Promocional:</span> <input type="number" name="valor_promocional"
						value="${promocao.valor_promocional}" class="form-control"
						required />
				</div>

				<p>
					<button type="reset" class="btn btn-danger">Desfazer</button>
					<button type="submit" class="btn btn-success">Atualizar</button>
				</p>
			</form>
		</div>
	</main>
	<footer>
		<hr />
		<div class="container">
			<!-- Início do rodapé -->
			<section class="row-footer mt-3">
				<div class="footer-logo">
					<img id="img-rodape" src="./img/beach-image-small.png" alt="" />
				</div>
				<div class="footer-menu">
					<ul type="none">
						<li><a href="./cadastro-promocao">Cadastro de Promoções</a></li>
						<li><a href="./views/admin/admin.html">Sair</a></li>
					</ul>
				</div>
			</section>
			<div class="row-endfooter">
				<p>
					Bora Bora Viagens - <img
						src="img/icons8-copyright-all-rights-reserved-20.png" alt="" />2022
				</p>
			</div>
			<!-- Fim do rodapé -->
		</div>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>