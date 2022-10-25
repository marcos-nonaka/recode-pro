import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AdminFooter from '../../../components/AdminFooter';
import AdminNavbar from '../../../components/AdminNavbar';

class PromocaoEdit extends Component {

    emptyItem = {
        destino: '',
        data_ida: '',
        horario_ida: '',
        data_volta: '',
        horario_volta: '',
        cia_aerea: '',
        hotel: '',
        observacoes: '',
        valor: '',
        valor_promocional: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const promocao = await (await fetch(`/cadastro-promocao/${this.props.match.params.id}`)).json();
            this.setState({ item: promocao });
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = { ...this.state.item };
        item[name] = value;
        this.setState({ item });
    }

    async handleSubmit(event) {
        event.preventDefault();
        const { item } = this.state;

        await fetch('/cadastro-promocao' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/cadastro-promocao');
    }

    render() {
        const { item } = this.state;
        const title = <h2>{item.id ? 'Editar Promoção' : 'Adicionar Promoção'}</h2>;

        return <div>
            <AdminNavbar />
            <Container>
                <div className="mt-4 p-5 bg-secondary text-white rounded">
                    <h1>Painel Administrador</h1>
                </div>
                <br />
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="name">Destino</Label>
                        <Input type="text" name="destino" id="destino" value={item.destino || ''}
                            onChange={this.handleChange} autoComplete="destino" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="data_ida">Data Ida</Label>
                        <Input type="date" name="data_ida" id="data_ida" value={item.data_ida || ''}
                            onChange={this.handleChange} autoComplete="data_ida" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="horario_ida">Horário Ida</Label>
                        <Input type="time" name="horario_ida" id="horario_ida" value={item.horario_ida || ''}
                            onChange={this.handleChange} autoComplete="horario_ida" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="data_volta">Data Volta</Label>
                        <Input type="date" name="data_volta" id="data_volta" value={item.data_volta || ''}
                            onChange={this.handleChange} autoComplete="data_volta" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="horario_volta">Horário Volta</Label>
                        <Input type="time" name="horario_volta" id="horario_volta" value={item.horario_volta || ''}
                            onChange={this.handleChange} autoComplete="horario_volta" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="cia_aerea">Cia Aérea</Label>
                        <Input type="text" name="cia_aerea" id="cia_aerea" value={item.cia_aerea || ''}
                            onChange={this.handleChange} autoComplete="cia_aerea" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="hotel">Hotel</Label>
                        <Input type="text" name="hotel" id="hotel" value={item.hotel || ''}
                            onChange={this.handleChange} autoComplete="hotel" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="observacoes">Observações</Label>
                        <Input type="text" name="observacoes" id="observacoes" value={item.observacoes || ''}
                            onChange={this.handleChange} autoComplete="observacoes" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="valor">Valor</Label>
                        <Input type="number" name="valor" id="valor" value={item.valor || ''}
                            onChange={this.handleChange} autoComplete="valor" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="valor_promocional">Valor Promocional</Label>
                        <Input type="number" name="valor_promocional" id="valor_promocional" value={item.valor_promocional || ''}
                            onChange={this.handleChange} autoComplete="valor_promocional" />
                    </FormGroup>
                    <br />
                    <FormGroup>
                        <Button color="primary" type="submit">Salvar</Button>{' '}
                        <Button color="secondary" tag={Link} to="/cadastro-promocao">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
            <AdminFooter />
        </div>
    }
}

export default withRouter(PromocaoEdit);