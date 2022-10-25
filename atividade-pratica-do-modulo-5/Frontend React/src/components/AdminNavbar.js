import React from 'react';

import Logo from '../img/logo-bora-bora-small.png';

const AdminNavbar = () => {
    return (
        <>
            <header>
                <div className="container">
                    <nav className="navbar navbar-expand-lg">
                        <div className="container-fluid">
                            <img src={Logo} alt="Logo Bora Bora" />
                            <button className="navbar-toggler" type="button"
                                data-bs-toggle="collapse" data-bs-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false"
                                aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon"></span>
                            </button>
                            <div className="collapse navbar-collapse" id="navbarNav">
                                <ul className="navbar-nav ms-auto">
                                    <li className="nav-item"><a className="nav-link"
                                        href="/cadastro-destino">Cadastro de Destinos</a></li>
                                    <li className="nav-item"><a className="nav-link"
                                        href="/cadastro-promocao">Cadastro de Promoções</a></li>
                                    <li className="nav-item"><a className="nav-link" href="/admin-login">Sair</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <hr className='horizontal-line' />
            </header>
        </>
    )
}

export default AdminNavbar;