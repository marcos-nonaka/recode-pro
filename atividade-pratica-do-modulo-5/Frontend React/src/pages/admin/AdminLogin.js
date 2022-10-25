import React from 'react';

import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';

const AdminLogin = () => {
    return (
        <>
            <Navbar />
            <main>
                <div className="container">
                    <div className="row">
                        <div className="mt-4 p-5 bg-secondary text-white rounded">
                            <h1>Painel Administrador</h1>
                        </div>
                        <div className="d-flex justify-content-center mt-4">
                            <form action="/admin-painel" className="col-xl-6 col-sm-6">
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Login:</span>
                                    <input type="text" className="form-control" />
                                </div>
                                <div className="input-group mb-3">
                                    <span className="input-group-text bg-secondary text-light">Senha:</span>
                                    <input type="password" className="form-control" />
                                </div>
                                <div className="d-grid gap-2 mb-3">
                                    <button type="submit" className="btn btn-secondary btn-lg">Entrar</button>
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

export default AdminLogin;