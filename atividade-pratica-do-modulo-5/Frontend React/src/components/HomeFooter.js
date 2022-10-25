import React from 'react';

import ImgRodape from '../img/beach-image-small.png';

const HomeFooter = () => {
    return (
        <>
            <footer>
                <div className="container">
                    <section className="row-footer mt-3">
                        <div className="footer-logo">
                            <img id="img-rodape"
                                src={ImgRodape}
                                alt="Imagem de rodapé"/>
                        </div>
                        <div className="footer-menu">
                            <ul type="none">
                                <li><a href="/">Home</a></li>
                                <li><a href="/destinos">Destinos</a></li>
                                <li><a href="/promocoes">Promoções</a></li>
                                <li><a href="/contato">Contato</a></li>
                                <li><a href="/admin-login">Admin</a></li>
                            </ul>
                        </div>
                    </section>
                    <div className="row-endfooter">
                        <p>Bora Bora Viagens - &copy; 2022</p>
                    </div>
                </div>
            </footer>
        </>
    )
}

export default HomeFooter;