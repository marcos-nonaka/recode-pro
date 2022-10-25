import React from 'react';

import AdminNavbar from '../../components/AdminNavbar';
import AdminFooter from '../../components/AdminFooter';

const AdminPainel = () => {
    return (
        <>
            <AdminNavbar />
            <main>
                <div class="container">
                    <div class="mt-4 p-5 bg-secondary text-white rounded">
                        <h1>Painel Administrador</h1>
                    </div>
                    <div class="row d-flex justify-content-center mt-4">
                        <div class="d-grid col-xl-6 col-sm-6 mb-3">
                            <a class="btn btn-secondary btn-lg" href="/cadastro-destino"
                                role="button">Cadastro de Destinos</a>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="d-grid col-xl-6 col-sm-6 mb-3">
                            <a class="btn btn-secondary btn-lg" href="/cadastro-promocao"
                                role="button">Cadastro de Promoções</a>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="d-grid col-xl-6 col-sm-6 mb-3">
                            <a class="btn btn-warning btn-lg" href="/admin-login" role="button">Sair</a>
                        </div>
                    </div>
                </div>
            </main>
            <AdminFooter />
        </>
    )
}

export default AdminPainel;