import React from 'react';

import Menu from '../Menu/Menu';
import PagoForm from './PagoForm';


function Pago()
{
    return(
        <>
        <Menu/>
        <main role="main" className="flex-shrink-0 mt-5">
            <div className="App-login">
                <PagoForm/>
            </div>
        </main>
        </>
    );
}

export default Pago;