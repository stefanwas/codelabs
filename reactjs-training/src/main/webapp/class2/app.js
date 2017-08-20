
//createElement(string/ReactClass type, [object props], [children ...]) -> ReactElement

var ContactItem = React.createClass({
  propTypes: {
    name: React.PropTypes.string.isRequired,
  },

  render: function() {
    return ( //<- me nawiasy są ważne!!! dlaczego?

        React.createElement('h2', {className: 'Contact-name'}, this.props.name)

    )
  },
});


var element = React.createElement(ContactItem, {name: "James K Nelson"})



ReactDOM.render(element, document.getElementById('react-app'))