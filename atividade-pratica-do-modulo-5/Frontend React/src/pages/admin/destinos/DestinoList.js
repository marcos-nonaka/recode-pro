import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AdminNavbar from '../../../components/AdminNavbar';
import AdminFooter from '../../../components/AdminFooter';
import { Link } from 'react-router-dom';

class DestinoList extends Component {

    constructor(props) {
        super(props);
        this.state = { destinos: [] };
    }

    componentDidMount() {
        fetch('/cadastro-destino')
            .then(response => response.json())
            .then(data => this.setState({ destinos: data }));
    }

    async remove(id) {
        await fetch(`/cadastro-destino/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedDestinos = [...this.state.destinos].filter(i => i.id !== id);
            this.setState({ destinos: updatedDestinos });
        });
    }

    render() {
        const { destinos } = this.state;

        const destinoList = destinos.map(destino => {
            return <tr key={destino.id}>
                <td>{destino.destino}</td>
                <td>{destino.data_ida}</td>
                <td>{destino.horario_ida}</td>
                <td>{destino.data_volta}</td>
                <td>{destino.horario_volta}</td>
                <td>{destino.cia_aerea}</td>
                <td>{destino.hotel}</td>
                <td>{destino.observacoes}</td>
                <td>{destino.valor}</td>
                <td>
                    <ButtonGroup>
                        <Button color="primary" tag={Link} to={"/cadastro-destino/" + destino.id}>Editar</Button>
                        <Button color="danger" onClick={() => this.remove(destino.id)}>Apagar</Button>
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
                        <Button color="success" tag={Link} to="/cadastro-destino/new" >Adicionar Destino</Button>{' '}
                        <Button color="warning" tag={Link} to="/admin-painel" >Voltar</Button>
                    </div>
                    <br />
                    <h3>Cadastro de Destinos</h3>
                    <div className="table-responsive">
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
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                {destinoList}
                            </tbody>
                        </Table>
                    </div>
                </Container >
                <AdminFooter />
            </div >
        );
    }
}

export default DestinoList;