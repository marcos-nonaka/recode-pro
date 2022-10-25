import React from 'react';

import Logo from '../img/logo-bora-bora-small.png';

const HomeNavbar = () => {
    return (
        <>
            <header>
                <div className="container">
                    <nav className="navbar navbar-expand-lg">
                        <div className="container-fluid">
                            <a className="navbar-brand" href="/"><img
                                src={Logo}
                                alt="Logo Bora Bora" /></a>
                            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon"></span>
                            </button>
                            <div className="collapse navbar-collapse" id="navbarNav">
                                <ul className="navbar-nav ms-auto">
                                    <li className="nav-item">
                                        <a className="nav-link active" aria-current="page" href="/">Home</a>
                                    </li>
                                    <li className="nav-item">
                                        <a className="nav-link" href="/destinos">Destinos</a>
                                    </li>
                                    <li className="nav-item">
                                        <a className="nav-link" href="/promocoes">Promoções</a>
                                    </li>
                                    <li className="nav-item">
                                        <a className="nav-link" href="/contato">Contato</a>
                                    </li>
                                    <li className="nav-item">
                                        <a className="nav-link" href="/admin-login">Admin</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </header>
        </>
    )
}

export default HomeNavbar;