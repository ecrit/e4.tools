/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.e4.cSS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.e4.cSS.selector#getSimpleselectors <em>Simpleselectors</em>}</li>
 *   <li>{@link org.eclipse.e4.cSS.selector#getCombinator <em>Combinator</em>}</li>
 *   <li>{@link org.eclipse.e4.cSS.selector#getSelector <em>Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.e4.cSS.CSSPackage#getselector()
 * @model
 * @generated
 */
public interface selector extends EObject
{
  /**
   * Returns the value of the '<em><b>Simpleselectors</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simpleselectors</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simpleselectors</em>' containment reference.
   * @see #setSimpleselectors(simple_selector)
   * @see org.eclipse.e4.cSS.CSSPackage#getselector_Simpleselectors()
   * @model containment="true"
   * @generated
   */
  simple_selector getSimpleselectors();

  /**
   * Sets the value of the '{@link org.eclipse.e4.cSS.selector#getSimpleselectors <em>Simpleselectors</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simpleselectors</em>' containment reference.
   * @see #getSimpleselectors()
   * @generated
   */
  void setSimpleselectors(simple_selector value);

  /**
   * Returns the value of the '<em><b>Combinator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Combinator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Combinator</em>' attribute.
   * @see #setCombinator(String)
   * @see org.eclipse.e4.cSS.CSSPackage#getselector_Combinator()
   * @model
   * @generated
   */
  String getCombinator();

  /**
   * Sets the value of the '{@link org.eclipse.e4.cSS.selector#getCombinator <em>Combinator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Combinator</em>' attribute.
   * @see #getCombinator()
   * @generated
   */
  void setCombinator(String value);

  /**
   * Returns the value of the '<em><b>Selector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selector</em>' containment reference.
   * @see #setSelector(selector)
   * @see org.eclipse.e4.cSS.CSSPackage#getselector_Selector()
   * @model containment="true"
   * @generated
   */
  selector getSelector();

  /**
   * Sets the value of the '{@link org.eclipse.e4.cSS.selector#getSelector <em>Selector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selector</em>' containment reference.
   * @see #getSelector()
   * @generated
   */
  void setSelector(selector value);

} // selector
