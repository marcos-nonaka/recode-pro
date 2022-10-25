import React from 'react';

import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

import Rio from '../img/rio.webp';
import Gramado from '../img/gramado.webp';
import Natal from '../img/natal.webp';
import Fortaleza from '../img/fortaleza.webp';
import PortoSeguro from '../img/porto-seguro.webp';
import FozDoIguacu from '../img/foz-do-iguacu.webp';

const Destinos = () => {
    return (
        <>
            <Navbar />
            <main>
                <div className="container">
                    <h1 className="text-dark">NOSSOS DESTINOS PARA CONHECER O BRASIL</h1>
                    <div className="row">
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={Rio} className="card-img-top" alt="Foto do Rio de Janeiro" />
                                <div className="card-body">
                                    <h5 className="card-title">Rio de Janeiro</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 742</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={Gramado} className="card-img-top" alt="Foto de Gramado" />
                                <div className="card-body">
                                    <h5 className="card-title">Gramado</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 1.219</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={Natal} className="card-img-top" alt="Foto de Natal" />
                                <div className="card-body">
                                    <h5 className="card-title">Natal</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 1.309</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={Fortaleza} className="card-img-top" alt="Foto de Fortaleza" />
                                <div className="card-body">
                                    <h5 className="card-title">Fortaleza</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 1.493</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={PortoSeguro} className="card-img-top" alt="Foto de Porto Seguro" />
                                <div className="card-body">
                                    <h5 className="card-title">Porto Seguro</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 1.523</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-6 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={FozDoIguacu} className="card-img-top" alt="Foto de Foz do Iguaçu" />
                                <div className="card-body">
                                    <h5 className="card-title">Foz do Iguaçu</h5>
                                    <p className="card-text">Pacotes a partir de <b>R$ 1.338</b></p>
                                    <a href="#" className="btn btn-primary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <Footer />
        </>
    )
}

export default Destinos;