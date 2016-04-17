import React from 'react';
import { render } from 'react-dom';
import { Button, Grid, Row, Col, Input, Panel } from 'react-bootstrap';
import _ from 'lodash';
import $ from 'jquery';

import Sudoku from './sudoku.js';

require('../styles/style.scss');
require('../styles/dummy.scss');

const dummyStylesheet = document.styleSheets[document.styleSheets.length - 1];
const endpoint = 'solve';

export default class SudokuApp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      boxesPerRow: 3,
      boxesPerColumn: 3
    };
    _.bindAll(this, 'changeSize', 'handleSubmit');
  }

  componentDidMount() {
    this.updateStylesheet();
  }

  componentDidUpdate(prevProps, prevState) {
    this.updateStylesheet();
  }

  changeSize() {
    if (document.getElementById('boxesPerRow').value && document.getElementById('boxesPerColumn').value) {
      this.setState({
        boxesPerRow: document.getElementById('boxesPerRow').value,
        boxesPerColumn: document.getElementById('boxesPerColumn').value
      });
    }
  }

  clearStylesheet() {
    while (dummyStylesheet.rules.length) {
      dummyStylesheet.deleteRule(0);
    }
  }

  updateStylesheet() {
    this.clearStylesheet();

    let containerWidth = $('#sudoku').width();
    let cellWidth = ((((containerWidth - 5) / this.state.boxesPerRow) - 4) / this.state.boxesPerColumn) - 2;

    let verticalRule = `.cell:nth-child(${this.state.boxesPerRow}n) { border-right: 5px solid black; }`,
        horizontalRule = `#sudoku :nth-child(${this.state.boxesPerColumn}n) .cell { border-bottom: 5px solid black; }`,
        widthRule = `.cell { width: ${Math.floor(cellWidth)}px; }`,
        heightRule = `.cell { height: ${Math.floor(cellWidth)}px; }`;

    dummyStylesheet.insertRule(verticalRule, 0);
    dummyStylesheet.insertRule(horizontalRule, 0);
    dummyStylesheet.insertRule(widthRule, 0);
    dummyStylesheet.insertRule(heightRule, 0);
  }

  /**
   * Technically, converts to an array of JSON objects, so this
   * still needs to be associated with a key to be a legit JSON object.
   */
  convertGivensToJSON(obj) {
    return _.chain(obj).mapValues((value, key) => {
      let s = key.split(',');
      return {
        row: s[0],
        column: s[1],
        digit: value
      }
    }).values().value();
  }

  convertJSONToGivens(array) {
    if (!array) {
      return null;
    }

    return _.inject(array, {}, (acc, val) => {
      let { row, column, digit } = val;
      acc[`${row},${column}`] = digit;
    });
  }

  handleSubmit() {
    let sudoku = this.refs.sudoku;

    if (sudoku.state.solved) {
      return;
    }

    let requestData = {
      givens: this.convertGivensToJSON(sudoku.state.givens),
      boxesPerRow: this.state.boxesPerRow,
      boxesPerColumn: this.state.boxesPerColumn
    };

    $.post(endpoint, JSON.stringify(requestData), 'json').then((data, status, jqXhr) => {
      console.log(data);
      console.log(status);
      console.log(jqXhr);

      let solution = JSON.parse(data).solution;
      sudoku.setState({
        solution: this.convertJSONToGivens(solution)
      });
    });
  }

  render() {
    let {
      boxesPerRow,
      boxesPerColumn
    } = this.state;

    return (
      <Panel className="wrapper">
        <Grid id="button-container">
          <Row>
            <Col style={{marginRight: '6px'}}>
              <Input type="number"
                     id="boxesPerRow"
                     label="boxes per row"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col>
              &times;
            </Col>
            <Col style={{marginLeft: '6px'}}>
              <Input type="number"
                     id="boxesPerColumn"
                     label="boxes per column"
                     min="2"
                     defaultValue="3"
                     bsSize="large"
                     onChange={this.changeSize} />
            </Col>
            <Col>
              <Button id="solve" bsStyle="primary" onClick={this.handleSubmit}>Solve</Button>
            </Col>
          </Row>
        </Grid>
        <Sudoku size={boxesPerRow * boxesPerColumn} ref='sudoku' />
      </Panel>
    );
  }
}

render(<SudokuApp />, document.getElementById('app'));
