import React from 'react';

import Navbar from '../components/Navbar';
import Footer from '../components/Footer';

import FaleConosco from '../img/fale-conosco.png';

const Contato = () => {
    return (
        <>
            <Navbar />
            <main>
                <div className="container">
                    <div className="row">
                        <div className="col-xl-12 col-sm-12 d-flex justify-content-center talk-with-us">
                            <img src={FaleConosco} alt="Imagem fale conosco" />
                        </div>
                        <div className="col-xl-12 col-sm-12 d-flex justify-content-center mt-4">
                            <form action="">
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Nome:</span>
                                    <input type="text" className="form-control" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Telefone:</span>
                                    <input type="tel" className="form-control" required />
                                    <span className="input-group-text bg-secondary text-light">E-mail:</span>
                                    <input type="email" className="form-control" required />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Assunto:</span>
                                    <select className="form-control" required>
                                        <option value="">--Selecione um assunto</option>
                                        <option value="">Reservas</option>
                                        <option value="">Sugestões</option>
                                        <option value="">Reclamações</option>
                                        <option value="">Outros</option>
                                    </select>
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Mensagem:</span>
                                    <textarea cols="" rows="10" className="form-control" required></textarea>
                                </div>
                                <div className="d-grid gap-2 mb-3">
                                    <button type="reset" className="btn btn-secondary">Limpar</button>
                                </div>
                                <div className="d-grid gap-2 mb-3">
                                    <button type="submit" className="btn btn-secondary btn-lg">Enviar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <Footer />
        </>
    )
}

export default Contato;