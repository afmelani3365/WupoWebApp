import React from 'react';
import Menu from '../Menu/Menu';
import Table from 'react-bootstrap/Table'

class Historico extends React.Component
{
    constructor(props){
        super(props);
        this.state = {pagos:[]}
        this.consultarHistorico = this.consultarHistorico.bind(this);
    }
    
    async consultarHistorico(token)
    {
        let response = await fetch('http://localhost:8080/historico', {method:'GET', headers:{'content-type':'application/json', 'authorization':'Bearer '+token} });
        let resulta = await response.json();
        this.setState({pagos:resulta});
        
    }

    componentDidMount(){
        const token = localStorage.getItem('token');
        if(token != null)
        {
            this.consultarHistorico(token);
        }
        else
        {
            this.setState({login:true})
        }
    }

    render(){

        let debeLogin = this.state.login ? true:false;

        if(debeLogin)
        {
            return(
                <>
                <Menu/>
                <main role="main" className="flex-shrink-0 mt-5">
                    <div className="App-login">
                        <h1>Debe iniciar sesión antes de poder visualizar los pagos</h1>
                    </div>
                </main>
                </>
            );
        }
        else
        {
            return(
                <>
                <Menu/>
                <main role="main" className="flex-shrink-0 mt-5">
                    <div className="App-login">
                    <Table striped bordered hover variant="dark">
                        <thead>
                            <tr>
                                <th>Usuario que envía</th>
                                <th>Destinatario</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                (this.state.pagos).map(function(pago, indice){
                                    return(<tr key={indice}>
                                        <td>{pago.source}</td>
                                        <td>{pago.destiny}</td>
                                        <td>{pago.value}</td>
                                    </tr>);
                                })
                            }
                        </tbody>
                    </Table>
                    </div>
                </main>
                </>
            );
        }
    }
}

export default Historico;