import React from 'react';

import HomeNavbar from '../components/HomeNavbar';
import HomeFooter from '../components/HomeFooter';

import AirplaneIcon from '../img/plane-departure-solid-white.png';
import PromotionIcon from '../img/hand-holding-dollar-solid-white.png';

const Home = () => {
    return (
        <>
            <HomeNavbar />
            <main>
                <section id="capa">
                    <div className="container">
                        <h1 id="texto-capa">Bora Bora Viagens</h1>
                        <h5 id="texto-capa">Olá! Bem-vindo(a) a Bora Bora Viagens! Aproveite as ofertas de hotéis, pacotes e
                            voos com os <br /> melhores preços para as suas férias!</h5>
                        <h5 id="texto-capa">Somos uma agência de viagens com mais de 10 anos de mercado e atendemos a todo o
                            Brasil, <br /> seja em viagens nacionais ou internacionais!</h5>
                        <div className="botoes">
                            <a href="/destinos">
                                <button role="button" className="botao">
                                    <img src={AirplaneIcon} alt="Ícone de avião" width="20px" height="16px" />
                                    DESTINOS
                                </button>
                            </a>
                            <a href="/promocoes">
                                <button role="button" className="botao">
                                    <img src={PromotionIcon} alt="Ícone de promoção" width="20px" height="16px" />
                                    PROMOÇÕES
                                </button>
                            </a>
                        </div>
                    </div>
                </section>
            </main>
            <HomeFooter />
        </>
    )
}

export default Home;