import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao, opcaoPermissoes, opcaoAdministradores, opcaoDestinos, opcaoPromocoes, id;
		String tipo, nome, email, senha, data_ida, horario_ida, data_volta, horario_volta, cia_aerea, hotel, observacoes;
		double valor, valor_promocional;

		PermissoesDAO permissoesDAO = new PermissoesDAO();
		AdministradoresDAO administradoresDAO = new AdministradoresDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		PromocoesDAO promocoesDAO = new PromocoesDAO();

		do {
			System.out.println("========== CRUD BORABORA ==========");
			System.out.println("1 - Cadastro de Permissoes");
			System.out.println("2 - Cadastro de Administradores");
			System.out.println("3 - Cadastro de Destinos");
			System.out.println("4 - Cadastro de Promocoes");
			System.out.println("5 - Sair");
			System.out.println("===================================");
			opcao = leia.nextInt();

			switch (opcao) {
			case 1:
				do {
					System.out.println("========== Permissoes ==========");
					System.out.println("1 - Cadastrar permissao");
					System.out.println("2 - Mostrar permissoes");
					System.out.println("3 - Atualizar permissao");
					System.out.println("4 - Excluir permissao");
					System.out.println("5 - Voltar");
					System.out.println("================================");
					opcaoPermissoes = leia.nextInt();

					switch (opcaoPermissoes) {
					case 1:
						Permissoes permissao = new Permissoes();
						System.out.println("Informe o TIPO de permissao:");
						tipo = leia.next();
						permissao.setTipo(tipo);

						permissoesDAO.save(permissao);
						System.out.println("Permissao adicionada com sucesso!");
						break;
					case 2:
						for (Permissoes p : permissoesDAO.getPermissoes()) {

							System.out.println("ID: " + p.getId_permissao());
							System.out.println("TIPO: " + p.getTipo());

							System.out.println("----------------------------------- ");
						}
						break;
					case 3:
						Permissoes permissaoUpdated = new Permissoes();
						System.out.println("Informe o ID da permissao a ser atualizada:");
						id = leia.nextInt();
						permissaoUpdated.setId_permissao(id);

						System.out.println("Informe o novo TIPO da permissao:");
						tipo = leia.next();
						permissaoUpdated.setTipo(tipo);

						permissoesDAO.update(permissaoUpdated);
						break;
					case 4:
						System.out.println("Qual o ID da permissao que voce quer excluir?");
						id = leia.nextInt();

						permissoesDAO.removeById(id);
						break;
					}
				} while (opcaoPermissoes != 5);
				break;
			case 2:
				do {
					System.out.println("========== Administradores ==========");
					System.out.println("1 - Cadastrar administrador");
					System.out.println("2 - Mostrar administradores");
					System.out.println("3 - Atualizar administrador");
					System.out.println("4 - Excluir administrador");
					System.out.println("5 - Voltar");
					System.out.println("=====================================");
					opcaoAdministradores = leia.nextInt();

					switch (opcaoAdministradores) {
					case 1:
						Administradores administrador = new Administradores();
						System.out.println("Informe o NOME do administrador:");
						nome = leia.next();
						administrador.setNome(nome);

						System.out.println("Informe o E-MAIL do administrador:");
						email = leia.next();
						administrador.setEmail(email);
						
						System.out.println("Informe a SENHA do administrador:");
						senha = leia.next();
						administrador.setSenha(senha);
						
						System.out.println("Informe o ID DA PERMISSAO para administrador:");
						id = leia.nextInt();
						administrador.setId_permissao(id);
						
						administradoresDAO.save(administrador);
						break;
					case 2:
						for (Administradores a : administradoresDAO.getAdministradores()) {

							System.out.println("ID: " + a.getId_admin());
							System.out.println("ID DA PERMISSAO: " + a.getId_permissao());
							System.out.println("NOME: " + a.getNome());
							System.out.println("E-MAIL: " + a.getEmail());
							System.out.println("SENHA: " + a.getSenha());

							System.out.println("----------------------------------- ");
						}
						break;
					case 3:
						Administradores administradorUpdated = new Administradores();
						System.out.println("Informe o ID do administrador a ser atualizado:");
						id = leia.nextInt();
						administradorUpdated.setId_admin(id);

						System.out.println("Informe o novo NOME do administrador:");
						nome = leia.next();
						administradorUpdated.setNome(nome);

						System.out.println("Informe o novo E-MAIL do administrador:");
						email = leia.next();
						administradorUpdated.setEmail(email);

						System.out.println("Informe a nova SENHA do administrador:");
						senha = leia.next();
						administradorUpdated.setSenha(senha);

						administradoresDAO.update(administradorUpdated);
						break;
					case 4:
						System.out.println("Qual o ID do administrador que voce quer excluir?");
						id = leia.nextInt();

						administradoresDAO.removeById(id);
						break;
					}
				} while (opcaoAdministradores != 5);
				break;
			case 3:
				do {
					System.out.println("========== Destinos ==========");
					System.out.println("1 - Cadastrar destino");
					System.out.println("2 - Mostrar destinos");
					System.out.println("3 - Atualizar destino");
					System.out.println("4 - Excluir destino");
					System.out.println("5 - Voltar");
					System.out.println("==============================");
					opcaoDestinos = leia.nextInt();

					switch (opcaoDestinos) {
					case 1:
						Destinos destino = new Destinos();
						System.out.println("Informe o DESTINO da viagem:");
						nome = leia.next();
						destino.setDestino(nome);

						System.out.println("Informe a DATA DE IDA:");
						data_ida = leia.next();
						destino.setData_ida(data_ida);
						
						System.out.println("Informe o HORARIO DE IDA:");
						horario_ida = leia.next();
						destino.setHorario_ida(horario_ida);
						
						System.out.println("Informe a DATA DE VOLTA:");
						data_volta = leia.next();
						destino.setData_volta(data_volta);
						
						System.out.println("Informe o HORARIO DE VOLTA:");
						horario_volta = leia.next();
						destino.setHorario_volta(horario_volta);
						
						System.out.println("Informe a CIA AEREA:");
						cia_aerea = leia.next();
						destino.setCia_aerea(cia_aerea);
						
						System.out.println("Informe o HOTEL:");
						hotel = leia.next();
						destino.setHotel(hotel);
						
						System.out.println("Informe as OBSERVACOES da viagem:");
						observacoes = leia.next();
						destino.setObservacoes(observacoes);
						
						System.out.println("Informe o VALOR do pacote de viagem:");
						valor = leia.nextDouble();
						destino.setValor(valor);
						
						System.out.println("Informe o ID DO ADMINISTRADOR de sistema:");
						id = leia.nextInt();
						destino.setId_admin(id);

						destinosDAO.save(destino);
						break;
					case 2:
						for (Destinos d : destinosDAO.getDestinos()) {

							System.out.println("ID: " + d.getId_destino());
							System.out.println("ID DO ADMINISTRADOR: " + d.getId_admin());
							System.out.println("DESTINO: " + d.getDestino());
							System.out.println("DATA DE IDA: " + d.getData_ida());
							System.out.println("HORARIO DE IDA: " + d.getHorario_ida());
							System.out.println("DATA DE VOLTA: " + d.getData_volta());
							System.out.println("HORARIO DE VOLTA: " + d.getHorario_volta());
							System.out.println("CIA AEREA: " + d.getCia_aerea());
							System.out.println("HOTEL: " + d.getHotel());
							System.out.println("OBSERVACOES: " + d.getObservacoes());
							System.out.println("VALOR: " + d.getValor());

							System.out.println("----------------------------------- ");
						}
						break;
					case 3:
						Destinos destinoUpdated = new Destinos();
						System.out.println("Informe o ID do destino a ser atualizado:");
						id = leia.nextInt();
						destinoUpdated.setId_destino(id);

						System.out.println("Informe o novo nome do DESTINO:");
						nome = leia.next();
						destinoUpdated.setDestino(nome);

						System.out.println("Informe a nova DATA DE IDA:");
						data_ida = leia.next();
						destinoUpdated.setData_ida(data_ida);

						System.out.println("Informe o novo HORARIO DE IDA:");
						horario_ida = leia.next();
						destinoUpdated.setHorario_ida(horario_ida);

						System.out.println("Informe a nova DATA DE VOLTA:");
						data_volta = leia.next();
						destinoUpdated.setData_volta(data_volta);

						System.out.println("Informe o novo HORARIO DE VOLTA:");
						horario_volta = leia.next();
						destinoUpdated.setHorario_volta(horario_volta);

						System.out.println("Informe a nova CIA AEREA:");
						cia_aerea = leia.next();
						destinoUpdated.setCia_aerea(cia_aerea);

						System.out.println("Informe o novo HOTEL:");
						hotel = leia.next();
						destinoUpdated.setHotel(hotel);

						System.out.println("Informe as novas OBSERVACOES da viagem:");
						observacoes = leia.next();
						destinoUpdated.setObservacoes(observacoes);

						System.out.println("Informe o novo VALOR da viagem:");
						valor = leia.nextDouble();
						destinoUpdated.setValor(valor);

						destinosDAO.update(destinoUpdated);
						break;
					case 4:
						System.out.println("Qual o ID do destino que voce quer excluir?");
						id = leia.nextInt();

						destinosDAO.removeById(id);
						break;
					}
				} while (opcaoDestinos != 5);
				break;
			case 4:
				do {
					System.out.println("========== Promocoes ==========");
					System.out.println("1 - Cadastrar promocao");
					System.out.println("2 - Mostrar promocoes");
					System.out.println("3 - Atualizar promocao");
					System.out.println("4 - Excluir promocao");
					System.out.println("5 - Voltar");
					System.out.println("===============================");
					opcaoPromocoes = leia.nextInt();

					switch (opcaoPromocoes) {
					case 1:
						Promocoes promocao = new Promocoes();
						System.out.println("Informe o DESTINO da viagem:");
						nome = leia.next();
						promocao.setDestino(nome);

						System.out.println("Informe a DATA DE IDA:");
						data_ida = leia.next();
						promocao.setData_ida(data_ida);
						
						System.out.println("Informe o HORARIO DE IDA:");
						horario_ida = leia.next();
						promocao.setHorario_ida(horario_ida);
						
						System.out.println("Informe a DATA DE VOLTA:");
						data_volta = leia.next();
						promocao.setData_volta(data_volta);
						
						System.out.println("Informe o HORARIO DE VOLTA:");
						horario_volta = leia.next();
						promocao.setHorario_volta(horario_volta);
						
						System.out.println("Informe a CIA AEREA:");
						cia_aerea = leia.next();
						promocao.setCia_aerea(cia_aerea);
						
						System.out.println("Informe o HOTEL:");
						hotel = leia.next();
						promocao.setHotel(hotel);
						
						System.out.println("Informe as OBSERVACOES da viagem:");
						observacoes = leia.next();
						promocao.setObservacoes(observacoes);
						
						System.out.println("Informe o VALOR do pacote de viagem:");
						valor = leia.nextDouble();
						promocao.setValor(valor);
						
						System.out.println("Informe o VALOR PROMOCIONAL do pacote de viagem:");
						valor_promocional = leia.nextDouble();
						promocao.setValor_promocional(valor_promocional);
						
						System.out.println("Informe o ID DO ADMINISTRADOR de sistema:");
						id = leia.nextInt();
						promocao.setId_admin(id);

						promocoesDAO.save(promocao);
						break;
					case 2:
						for (Promocoes p : promocoesDAO.getPromocoes()) {

							System.out.println("ID: " + p.getId_promocao());
							System.out.println("ID DO ADMINISTRADOR: " + p.getId_admin());
							System.out.println("DESTINO: " + p.getDestino());
							System.out.println("DATA DE IDA: " + p.getData_ida());
							System.out.println("HORARIO DE IDA: " + p.getHorario_ida());
							System.out.println("DATA DE VOLTA: " + p.getData_volta());
							System.out.println("HORARIO DE VOLTA: " + p.getHorario_volta());
							System.out.println("CIA AEREA: " + p.getCia_aerea());
							System.out.println("HOTEL: " + p.getHotel());
							System.out.println("OBSERVACOES: " + p.getObservacoes());
							System.out.println("VALOR: " + p.getValor());
							System.out.println("VALOR PROMOCIONAL: " + p.getValor_promocional());

							System.out.println("----------------------------------- ");
						}
						break;
					case 3:
						Promocoes promocaoUpdated = new Promocoes();
						System.out.println("Informe o ID da promocao a ser atualizada:");
						id = leia.nextInt();
						promocaoUpdated.setId_promocao(id);

						System.out.println("Informe o novo nome do DESTINO:");
						nome = leia.next();
						promocaoUpdated.setDestino(nome);

						System.out.println("Informe a nova DATA DE IDA:");
						data_ida = leia.next();
						promocaoUpdated.setData_ida(data_ida);

						System.out.println("Informe o novo HORARIO DE IDA:");
						horario_ida = leia.next();
						promocaoUpdated.setHorario_ida(horario_ida);

						System.out.println("Informe a nova DATA DE VOLTA:");
						data_volta = leia.next();
						promocaoUpdated.setData_volta(data_volta);

						System.out.println("Informe o novo HORARIO DE VOLTA:");
						horario_volta = leia.next();
						promocaoUpdated.setHorario_volta(horario_volta);

						System.out.println("Informe a nova CIA AEREA:");
						cia_aerea = leia.next();
						promocaoUpdated.setCia_aerea(cia_aerea);

						System.out.println("Informe o novo HOTEL:");
						hotel = leia.next();
						promocaoUpdated.setHotel(hotel);

						System.out.println("Informe as novas OBSERVACOES da viagem:");
						observacoes = leia.next();
						promocaoUpdated.setObservacoes(observacoes);

						System.out.println("Informe o novo VALOR da viagem:");
						valor = leia.nextDouble();
						promocaoUpdated.setValor(valor);

						System.out.println("Informe o novo VALOR PROMOCIONAL do pacote de viagem:");
						valor_promocional = leia.nextDouble();
						promocaoUpdated.setValor(valor_promocional);

						promocoesDAO.update(promocaoUpdated);
						break;
					case 4:
						System.out.println("Qual o ID da promocao que voce quer excluir?");
						id = leia.nextInt();

						promocoesDAO.removeById(id);
						break;
					}
				} while (opcaoPromocoes != 5);
				break;
			case 5:
				leia.close();
				System.out.println("Ate mais!");
				break;
			}
		} while (opcao != 5);
	}
}