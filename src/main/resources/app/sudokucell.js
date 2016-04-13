import React from 'react';
import $ from 'jquery';
import _ from 'lodash';

export default class SudokuCell extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      digit: null
    }
    _.bindAll(this, 'onChange');
  }

  componentWillUpdate(nextProps, nextState) {
    if (this.state.digit != nextState.digit) {
      this.props.onUpdateCell(nextProps.row, nextProps.column, nextState.digit);
    }
  }

  onChange(evt) {
    this.setState({
      digit: evt.target.value
    });
  }

  render() {
    return (
      <div className="cell">
        <input style={{width: '100%', height: '100%', border: 'none'}}
               id={`cell[${this.props.row},${this.props.column}]`}
               type="text"
               onChange={this.onChange} />
      </div>
    );
  }
}
