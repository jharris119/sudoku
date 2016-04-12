import React from 'react';
import Radium from 'radium';
import $ from 'jquery';

export default class SudokuCell extends React.Component {
  constructor(props) {
    super(props);
    this.styles = {
      base: {
        width: '62px',
        height: '62px'
      }
    }
  }

  renderStyles() {
    let cellWidth = document.getElementById('content').width / this.props.size;
    this.styles.base.width = this.styles.base.height = cellWidth + 'px';
  }

  render() {
    return (<input style={this.styles.base} id={`cell[${this.props.row},${this.props.column}]`} type="text" />);
  }
}

SudokuCell = Radium(SudokuCell);
