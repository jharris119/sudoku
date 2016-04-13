import React from 'react';
import _ from 'lodash';

import SudokuCell from './sudokucell.js';

export default class Sudoku extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      givens: {},
      solved: false
    }
    _.bindAll(this, 'onUpdateCell');
  }

  componentWillUpdate(nextProps, nextState) {
    console.log('Sudoku.componentWillUpdate: %O, %O', nextProps, nextState);
  }

  componentDidUpdate(prevProps, prevState) {
    console.log('Sudoku.componentDidUpdate: %O, %O', prevProps, prevState);
  }

  onUpdateCell(row, column, digit) {
    console.log('Sudoku.onUpdateCell');

    let key = `${row},${column}`,
        newGivens = Object.assign({}, this.state.givens);

    if (digit) {
      newGivens[key] = digit;
    }
    else {
      delete newGivens[key];
    }
    this.setState({
      givens: newGivens
    });
  }

  render() {
    console.log('Sudoku.render');

    return (
      <div id="sudoku">
        {
          _.range(this.props.size).map((r) => {
            return (
              <div id={`row${r}`}>{
                _.range(this.props.size).map((c) => {
                  return (
                    <SudokuCell row={r + 1}
                                column={c + 1}
                                onUpdateCell={this.onUpdateCell} />
                  );
                })}
              </div>
            );
          })
        }
      </div>
    );
  }
}
