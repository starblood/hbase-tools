/*
 * Copyright 2015 Kakao Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kakao.hbase;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.junit.Test;

import java.util.List;

public class OptionParserTest {
    @Test
    public void testOptionParser() throws Exception {
        OptionParser optionParser = new OptionParser();

        String[] args = {"command", "--option2=1", "zookeeper", "--option1", "tablename", "--option3"};

        optionParser.accepts("option2").withRequiredArg();
        optionParser.accepts("option2").withRequiredArg();
        optionParser.accepts("option3").withOptionalArg();
        optionParser.accepts("option1");

        OptionSet optionSet = optionParser.parse(args);
        List<?> argList = optionSet.nonOptionArguments();
        System.out.println(argList);
        System.out.println(optionSet.asMap());
    }
}
