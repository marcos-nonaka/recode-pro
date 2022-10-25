import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import './css/style.css';

import Home from './pages/Home';
import Destinos from './pages/Destinos';
import Promocoes from './pages/Promocoes';
import Contato from './pages/contato';
import AdminLogin from './pages/admin/AdminLogin';
import AdminPainel from './pages/admin/AdminPainel';
import DestinoList from './pages/admin/destinos/DestinoList';
import DestinoEdit from './pages/admin/destinos/DestinoEdit';
import PromocaoList from './pages/admin/promocoes/PromocaoList';
import PromocaoEdit from './pages/admin/promocoes/PromocaoEdit';

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/destinos' component={Destinos}/>
            <Route path='/promocoes' component={Promocoes}/>
            <Route path='/contato' component={Contato}/>
            <Route path='/admin-login' component={AdminLogin}/>
            <Route path='/admin-painel' component={AdminPainel}/>
            <Route path='/cadastro-destino' exact={true} component={DestinoList}/>
            <Route path='/cadastro-destino/:id' component={DestinoEdit}/>
            <Route path='/cadastro-promocao' exact={true} component={PromocaoList}/>
            <Route path='/cadastro-promocao/:id' component={PromocaoEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;