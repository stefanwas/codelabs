var personArray = ['Wotjek', 'Stefan'];

var Person = React.createClass({
  propTypes: {
    name: React.PropTypes.string.isRequired,
  },

  render: function() {
    return (
        React.createElement('li', {}, this.props.name)
    )
  },
});


var PersonList = React.createClass({
    propTypes: {
        personList: React.PropTypes.array.isRequired,
    },

    render: function() {

        var personElements = this.props.personList
            .map(function (person) {
                return React.createElement(Person, {name: person, key: person}); // key jest potrzebny do identfikacji elementów na liście (inaczej React Warning)
            });

        return (
            React.createElement('ul', {}, personElements)
        )
    },
});

var button = React.createElement('button',
    {
        type: 'button',
        onClick :   function (e) {
                        personArray.push('XXXX'); // to jednak nie odświeża strony
                        console.log(personArray);
                    }
    },
    "Add person");


var personList = React.createElement(PersonList, {personList : personArray});

ReactDOM.render(personList, document.getElementById('react-app1'));
ReactDOM.render(button, document.getElementById('react-app2'));