import React from 'react';
import Radium from 'radium';
import $ from 'jquery';

export default class SudokuCell extends React.Component {
  constructor(props) {
    super(props);
    this.styles = {
      base: {
        width: '62px',
        height: '62px',
        float: 'left',
        border: '1px solid black'
      }
    }
  }

  getStyle() {
    let borderStyles = {};
    if (this.props.row == 1) {
      borderStyles.borderTop = '5px solid black';
    }
    if (this.props.column == 1) {
      borderStyles.clear = 'both';
      borderStyles.borderLeft = '5px solid black';
    }
    if (this.props.boxBottom) {
      borderStyles.borderBottom = '5px solid black';
    }
    if (this.props.boxRight) {
      borderStyles.borderRight = '5px solid black';
    }
    return Object.assign(this.styles.base, borderStyles);
  }

  render() {
    return (
      <div style={this.getStyle()}>
        <input style={{width: '100%', height: '100%', border: 'none'}} id={`cell[${this.props.row},${this.props.column}]`} type="text" />
      </div>
    );
  }
}

SudokuCell = Radium(SudokuCell);
