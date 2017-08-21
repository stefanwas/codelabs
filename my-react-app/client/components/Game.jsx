import React from 'react';
import _ from 'lodash';

class Square extends React.Component {

  constructor() {
    super();
    this.state = {
      value: null,
    };
  }

  render() {
    return (
      <button className="square" onClick={() => alert('click')}>
        {this.props.value}
      </button>
    );
  }
}

class Board extends React.Component {

  renderSquare(i) {
    return <Square value={i}/>;
  }

  renderRow(n) {
     var row = _.range(3).map(i => <Square value={3 * n + i} key={i}/>);
    return ( <div className="board-row" key={n}> {row} </div>  );
  }

  render() {
    const status = 'Next player: X';

    var rows = [];
    for (var n = 0; n < 3; n++) {
        rows.push( this.renderRow(n));
    }

    return (<div> {rows} </div>);

  }
}

export default class Game extends React.Component {
  render() {
    return (
      <div className="game">
        <div className="game-board">
          <Board />
        </div>
        <div className="game-info">
          <div>{/* status */}</div>
          <ol>{/* TODO */}</ol>
        </div>
      </div>
    );
  }
}



