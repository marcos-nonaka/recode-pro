import React from 'react';

import ImgRodape from '../img/beach-image-small.png';

const AdminFooter = () => {
    return (
        <>
            <footer>
                <hr className='horizontal-line' />
                <div class="container">
                    <section class="row-footer mt-3">
                        <div class="footer-logo">
                            <img id="img-rodape" src={ImgRodape} alt="Imagem de rodapé" />
                        </div>
                        <div class="footer-menu">
                            <ul type="none">
                                <li><a href="/cadastro-destino">Cadastro de Destinos</a></li>
                                <li><a href="/cadastro-promocao">Cadastro de Promoções</a></li>
                                <li><a href="/admin-login">Sair</a></li>
                            </ul>
                        </div>
                    </section>
                    <div class="row-endfooter">
                        <p>
                            Bora Bora Viagens - &copy; 2022
                        </p>
                    </div>
                </div>
            </footer>
        </>
    )
}

export default AdminFooter;