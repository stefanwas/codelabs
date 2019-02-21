import React from 'react';

export default class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            test: 'test 123'
        };
    }

    render() {
        let x = 'Bela';

        return (
            <div>
                <span>{x} i Ula i Ela i Tadeusz</span>
            </div>
        );
    }


}