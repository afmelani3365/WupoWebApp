import React from 'react';
import {NavLink} from 'react-router-dom';

class Menu extends React.Component {

    render() {
        return (
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <NavLink to="/" className="navbar-brand">WupoDemo</NavLink>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <NavLink to="/" className="nav-link">Home<span className="sr-only">(current)</span></NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/login" className="nav-link">Login</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/user" className="nav-link">Realizar pago</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink to="/historico" className="nav-link">Historico</NavLink>
                        </li>
                    </ul>
                </div>
            </nav>
        )
    }
}

export default Menu;