
//createElement(string/ReactClass type, [object props], [children ...]) -> ReactElement

//Opcja 1 - funkcja onChange jest zdefiniowana w klasie ContactItem

var ContactItem = React.createClass({
  propTypes: {
    name: React.PropTypes.string.isRequired,
//    onChange: React.PropTypes.func.isRequired,
  },

  render: function() {
    return (

        React.createElement('input', {
            type: 'text',
            defaultValue: this.props.name,
            onChange: function(input) { console.log(input) }
        })

    )
  },
});


var element = React.createElement(ContactItem, {
    name: "James K Nelson",
});


// Opcja 2 - funkcja onChange jest przekazana jako argument przy tworeniu w elemencie

//var ContactItem = React.createClass({
//  propTypes: {
//    name: React.PropTypes.string.isRequired,
//    onChange: React.PropTypes.func.isRequired,
//  },
//
//  render: function() {
//    return (
//
//        React.createElement('input', {
//            type: 'text',
//            defaultValue: this.props.name,
//            onChange: this.props.onChange
//        })
//
//    )
//  },
//});
//
//
//var element = React.createElement(ContactItem, {
//    name: "James K Nelson",
//    onChange: function(input) { console.log(input) },
//});


ReactDOM.render(element, document.getElementById('react-app'));