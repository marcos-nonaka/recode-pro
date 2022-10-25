import React from 'react';

import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

import BannerOfertas from '../img/ofertas-600-158.png';
import MulherOferta from '../img/promo-com-mulher-400-400.png';
import BuenosAires from '../img/buenos-aires.webp';
import PortoDeGalinhas from '../img/porto-de-galinhas.webp';
import Maceio from '../img/maceio.webp';

const Promocoes = () => {
    return (
        <>
            <Navbar />
            <main>
                <div className="container">
                    <h1 className="text-dark">APROVEITE OFERTAS DE PACOTES DE VIAGEM</h1>
                    <div className="row">
                        <div className="col-lg-12 col-sm-12 d-flex justify-content-center" id="banner-ofertas">
                            <img src={BannerOfertas}
                                alt="Banner de ofertas" />
                        </div>
                        <div className="col-xl-6 d-flex justify-content-center" id="mulher-oferta">
                            <img src={MulherOferta} alt="Imagem de mulher oferta" />
                        </div>
                        <div className="col-xl-2 col-lg-4 col-sm-12 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={BuenosAires} className="card-img-top" alt="Foto de Buenos Aires" />
                                <div className="card-body">
                                    <h5 className="card-title">Buenos Aires</h5>
                                    <p className="card-text">Pacotes a partir de <br /><del className="text-danger">R$ 2.408</del><br /><b className="text-success">por R$ 2.047</b></p>
                                    <a href="#" className="btn btn-secondary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-xl-2 col-lg-4 col-sm-12 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={PortoDeGalinhas} className="card-img-top" alt="Foto de Porto de Galinhas" />
                                <div className="card-body">
                                    <h5 className="card-title">Porto de Galinhas</h5>
                                    <p className="card-text">Pacotes a partir de <br /><del className="text-danger">R$ 1.809</del><br /><b className="text-success">por R$ 1.628</b></p>
                                    <a href="#" className="btn btn-secondary">Saiba mais</a>
                                </div>
                            </div>
                        </div>
                        <div className="col-xl-2 col-lg-4 col-sm-12 mt-4 d-flex justify-content-center">
                            <div className="card" width="18rem">
                                <img src={Maceio} className="card-img-top" alt="Foto de Maceió" />
                                <div className="card-body">
                                    <h5 className="card-title">Maceió</h5>
                                    <p className="card-text">Pacotes a partir de <br /><del className="text-danger">R$ 1.581</del><br /><b className="text-success">por R$ 1.265</b></p>
                                    <a href="#" className="btn btn-secondary">Saiba mais</a>
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

export default Promocoes;