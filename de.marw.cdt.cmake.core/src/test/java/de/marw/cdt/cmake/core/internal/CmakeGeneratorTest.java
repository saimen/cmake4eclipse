/*******************************************************************************
 * Copyright (c) 2018 Martin Weber.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Martin Weber - Initial implementation
 *******************************************************************************/

package de.marw.cdt.cmake.core.internal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author weber
 *
 */
public class CmakeGeneratorTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Test method for
   * {@link de.marw.cdt.cmake.core.internal.CmakeGenerator#getParallelBuildArg(int)}.
   */
  @Test
  public void testGetParallelBuildArg_Off() {
    assertEquals(null, CmakeGenerator.UnixMakefiles.getParallelBuildArg(1));
    assertEquals("-j 1", CmakeGenerator.Ninja.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.MinGWMakefiles.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.MSYSMakefiles.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.NMakeMakefiles.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.NMakeMakefilesJOM.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.BorlandMakefiles.getParallelBuildArg(1));
    assertEquals(null, CmakeGenerator.WatcomWMake.getParallelBuildArg(1));
  }

  /**
   * Test method for
   * {@link de.marw.cdt.cmake.core.internal.CmakeGenerator#getParallelBuildArg(int)}.
   */
  @Test
  public void testGetParallelBuildArg_Unlimited() {
    assertEquals("-j", CmakeGenerator.UnixMakefiles.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals("-j " + Integer.MAX_VALUE, CmakeGenerator.Ninja.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals("-j", CmakeGenerator.MinGWMakefiles.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals("-j", CmakeGenerator.MSYSMakefiles.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals(null, CmakeGenerator.NMakeMakefiles.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals("-j " + Integer.MAX_VALUE, CmakeGenerator.NMakeMakefilesJOM.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals(null, CmakeGenerator.BorlandMakefiles.getParallelBuildArg(Integer.MAX_VALUE));
    assertEquals(null, CmakeGenerator.WatcomWMake.getParallelBuildArg(Integer.MAX_VALUE));
  }

  /**
   * Test method for
   * {@link de.marw.cdt.cmake.core.internal.CmakeGenerator#getParallelBuildArg(int)}.
   */
  @Test
  public void testGetParallelBuildArg_User() {
    int value = 123;
    assertEquals("-j " + value, CmakeGenerator.UnixMakefiles.getParallelBuildArg(value));
    assertEquals("-j " + value, CmakeGenerator.Ninja.getParallelBuildArg(value));
    assertEquals("-j " + value, CmakeGenerator.MinGWMakefiles.getParallelBuildArg(value));
    assertEquals("-j " + value, CmakeGenerator.MSYSMakefiles.getParallelBuildArg(value));
    assertEquals(null, CmakeGenerator.NMakeMakefiles.getParallelBuildArg(value));
    assertEquals("-j " + value, CmakeGenerator.NMakeMakefilesJOM.getParallelBuildArg(value));
    assertEquals(null, CmakeGenerator.BorlandMakefiles.getParallelBuildArg(value));
    assertEquals(null, CmakeGenerator.WatcomWMake.getParallelBuildArg(value));
  }
}
