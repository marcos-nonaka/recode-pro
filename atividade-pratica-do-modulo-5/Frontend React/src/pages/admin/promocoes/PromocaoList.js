import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AdminNavbar from '../../../components/AdminNavbar';
import AdminFooter from '../../../components/AdminFooter';
import { Link } from 'react-router-dom';

class PromocaoList extends Component {

    constructor(props) {
        super(props);
        this.state = { promocoes: [] };
    }

    componentDidMount() {
        fetch('/cadastro-promocao')
            .then(response => response.json())
            .then(data => this.setState({ promocoes: data }));
    }

    async remove(id) {
        await fetch(`/cadastro-promocao/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedPromocoes = [...this.state.promocoes].filter(i => i.id !== id);
            this.setState({ promocoes: updatedPromocoes });
        });
    }

    render() {
        const { promocoes } = this.state;

        const promocaoList = promocoes.map(promocao => {
            return <tr key={promocao.id}>
                <td>{promocao.destino}</td>
                <td>{promocao.data_ida}</td>
                <td>{promocao.horario_ida}</td>
                <td>{promocao.data_volta}</td>
                <td>{promocao.horario_volta}</td>
                <td>{promocao.cia_aerea}</td>
                <td>{promocao.hotel}</td>
                <td>{promocao.observacoes}</td>
                <td>{promocao.valor}</td>
                <td>{promocao.valor_promocional}</td>
                <td>
                    <ButtonGroup>
                        <Button color="primary" tag={Link} to={"/cadastro-promocao/" + promocao.id}>Editar</Button>
                        <Button color="danger" onClick={() => this.remove(promocao.id)}>Apagar</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AdminNavbar />
                <Container>
                    <div className="mt-4 p-5 bg-secondary text-white rounded">
                        <h1>Painel Administrador</h1>
                    </div>
                    <br />
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/cadastro-promocao/new" >Adicionar Promoção</Button>{' '}
                        <Button color="warning" tag={Link} to="/admin-painel" >Voltar</Button>
                    </div>
                    <br />
                    <h3>Cadastro de Promoções</h3>
                    <div className='table-responsive'>
                        <Table className="mt-4">
                            <thead>
                                <tr>
                                    <th>Destino</th>
                                    <th>Data Ida</th>
                                    <th>Horário Ida</th>
                                    <th>Data Volta</th>
                                    <th>Horário Volta</th>
                                    <th>Cia Aérea</th>
                                    <th>Hotel</th>
                                    <th>Observações</th>
                                    <th>Valor</th>
                                    <th>Valor Promocional</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                {promocaoList}
                            </tbody>
                        </Table>
                    </div>
                </Container>
                <AdminFooter />
            </div>
        );
    }
}

export default PromocaoList;