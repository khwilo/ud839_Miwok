/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> word = new ArrayList<Word>();

        word.add(new Word("red", "weṭeṭṭi"));
        word.add(new Word("green", "chokokki"));
        word.add(new Word("brown", "ṭakaakki"));
        word.add(new Word("gray", "ṭopoppi"));
        word.add(new Word("black", "kululli"));
        word.add(new Word("white", "kelelli"));
        word.add(new Word("dusty yellow", "ṭopiisә"));
        word.add(new Word("mustard yellow", "chiwiiṭә"));
    }
}
