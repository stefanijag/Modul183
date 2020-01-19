import './style.css';

class viewLogin extends Component {
     setUsername(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, username: event.target.value}});
    }

    setPasswort(event){
        this.setState({...this.state, loginBean: {...this.state.loginBean, passwort: event.target.value}});
    }


    submit(event){
        let invalidFields = validateUser(this.state.user);
        if(invalidFields.length === 0){
            axios({
                method: "post",
                url: `http://${window.location.hostname}:8080/registerUser`,
                withCredentials: true,
                data: {...this.state.user}
            }).then(res => {
                this.props.context.setUserRole(res.data.role);
                this.setState({...this.state, redirectToHome: true});
            }).catch(error => {
                console.log(error);
                if(error.response && error.response.status === 400){
                    this.setState({...this.state, invalidFields: error.response.data, errorMsg: null});
                }
            });
        }
        else{
            this.setState({...this.state, invalidFields, errorMsg: null});
        }
    }

        return (
            <div>
                <form className="loginForm">
                    <h1>Login</h1>
                    <table>
                        <tbody>
                            <tr className="errorMsg"><td colSpan={3}>{this.state.errorMsg}</td></tr>
                            <tr>
                                <td className="loginText">Username:</td>
                                <td><input type="text" value={this.state.username} onChange={this.username}></input></td>
                            </tr>
                            <tr>
                                <td className="loginText">Password:</td>
                                <td><input type="password" value={this.state.password} onChange={this.setPassword}></input></td>
                            </tr>
                            <tr>
                                <td><div className="button" onClick={this.submit}>Kein Account? Registriere dich hier</div></td>
                                <td><Link to="/" className="buttonLink"><div className="button">Abbrechen</div></Link></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        );
    }
}

export default WithContext(login);