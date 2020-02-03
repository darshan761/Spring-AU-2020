class SplashPage extends Component {

    componentWillMount () {
        var navigator = this.props.navigator;
        setTimeout (() => {
            navigator.replace({
                id: 'Home', <-- This is the View you go to
            });
        }, 5000); <-- Time until it jumps to "MainView" 
    }
    render () {
        return (
            <View style={{flex: 1, backgroundColor: 'red', alignItems: 'center', justifyContent: 'center'}}>
                <Image style={{position: 'absolute', left: 0, top: 0, width: windowSize.width, height: windowSize.height}} source={require('image!splash_screen')}></Image>
            </View>
        );
    }
}

module.exports = SplashPage;