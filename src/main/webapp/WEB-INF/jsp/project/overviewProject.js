import './style.css';

class viewRegister extends Component {

    setProjectName(event){
        this.setState({...this.state, projectBean: {...this.state.projectBean, projectname: event.target.value}});
    }

    setReleaseDate(event){
        this.setState({...this.state, projectBean: {...this.state.projectBean, releasedate: event.target.value}});
    }
    
    setDescription(event){
        this.setState({...this.state, projectBean: {...this.state.projectBean, description: event.target.value}});
    }

    setTeam(event){
        this.setState({...this.state, projectBean: {...this.state.projectBean, team: event.target.value}});
    }

    submit(event){
        let invalidFields = validateUser(this.state.user);
        if(invalidFields.length === 0){
            axios({
                method: "post",
                url: `http://${window.location.hostname}:8080/register`,
                withCredentials: true,
                data: {...this.state.loginBean}
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

    render(){
        if(this.state.redirectToHome){
            return <Redirect to="/"/>;
        }

        return (
            <div>
                <form className="overviewAdin">
                    <h1>Overview</h1>
                    <table>
                        <tbody>
                            <tr className="errorMsg"><td colSpan={3}>{this.state.errorMsg}</td></tr>
                            <tr>
                                <td className="loginText">Projektname:</td>
                                <td>this.state.projectName</td>
                            </tr>
                            <tr>
                                <td className="loginText">Release Date:</td>
                                <td>this.state.releasedate</td>
                            </tr>
                            <tr>
                                <td className="loginText">Beschreibung:</td>
                                <td>this.state.description</td>
                            </tr>
                            <tr>
                                <td className="loginText">Team:</td>
                                	<td>this.state.team</td>
                            </tr>
                            <tr>
                                <td><div className="button" onClick={this.submit}>Bestätigen</div></td>
                                <td><Link to="/" className="buttonLink"><div className="button">Abbrechen</div></Link></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
        );
    }
}

export default WithContext(menu);