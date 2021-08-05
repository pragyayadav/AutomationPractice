{
  "nbformat": 4,
  "nbformat_minor": 0,
  "metadata": {
    "colab": {
      "name": "Untitled0.ipynb",
      "provenance": [],
      "authorship_tag": "ABX9TyNifSy9fWr3naH12GIenQ0M",
      "include_colab_link": true
    },
    "kernelspec": {
      "name": "python3",
      "display_name": "Python 3"
    },
    "language_info": {
      "name": "python"
    }
  },
  "cells": [
    {
      "cell_type": "markdown",
      "metadata": {
        "id": "view-in-github",
        "colab_type": "text"
      },
      "source": [
        "<a href=\"https://colab.research.google.com/github/pragyayadav/AutomationPractice/blob/master/res_net.py\" target=\"_parent\"><img src=\"https://colab.research.google.com/assets/colab-badge.svg\" alt=\"Open In Colab\"/></a>"
      ]
    },
    {
      "cell_type": "code",
      "metadata": {
        "id": "K4gY_cf-xYmI"
      },
      "source": [
        "from keras.layers import Input, Add, Dense, Activation, ZeroPadding2D, BatchNormalization, Flatten, Conv2D, AveragePooling2D, MaxPooling2D, GlobalMaxPooling2D\n",
        "from keras.initializers import glorot_uniform\n",
        "from keras.models import Model, load_model\n",
        "from custom_layers.scale_layer import Scale\n",
        "from keras.optimizers import SGD\n",
        "\n",
        "#Structure of an identity block:\n",
        "from identity_block import *\n",
        "\n",
        "#Structure of a Convolution Block:\n",
        "from conv_block import *\n",
        "\n",
        "def ResNet(input_shape = (224, 224, 3), classes = 196):\n",
        "    \"\"\"\n",
        "    Implementation of the popular ResNet50 the following architecture:\n",
        "    CONV2D -> BATCHNORM -> RELU -> MAXPOOL -> CONVBLOCK -> IDBLOCK*2 -> CONVBLOCK -> IDBLOCK*3\n",
        "    -> CONVBLOCK -> IDBLOCK*5 -> CONVBLOCK -> IDBLOCK*2 -> AVGPOOL -> TOPLAYER\n",
        "\n",
        "    Arguments:\n",
        "    input_shape -- shape of the images of the dataset\n",
        "    classes -- integer, number of classes\n",
        "\n",
        "    Returns:\n",
        "    model -- a Model() instance in Keras\n",
        "    \"\"\"\n",
        "    #Set epsilon value for Batch Normalization\n",
        "    eps = 1.1e-5\n",
        "\n",
        "    # Define the input as a tensor with shape input_shape\n",
        "    X_input = Input(input_shape)\n",
        "\n",
        "    \n",
        "    # Zero-Padding\n",
        "    X = ZeroPadding2D((3, 3))(X_input)\n",
        "\n",
        "    # Stage 1\n",
        "    X = Conv2D(64, (7, 7), strides = (2, 2), name = 'conv1', use_bias=False, kernel_initializer = glorot_uniform(seed=0))(X)\n",
        "    X = BatchNormalization(epsilon = eps, axis = 3, name = 'bn_conv1')(X)\n",
        "    X = Scale(axis = 3, name = 'scale_conv1')(X)\n",
        "    X = Activation('relu')(X)\n",
        "    X = MaxPooling2D((3, 3), strides=(2, 2))(X)\n",
        "\n",
        "    # Stage 2\n",
        "    X = convolutional_block(X, f = 3, filters = [64, 64, 256], stage = 2, block='a', s = 1)\n",
        "    X = identity_block(X, 3, [64, 64, 256], stage=2, block='b')\n",
        "    X = identity_block(X, 3, [64, 64, 256], stage=2, block='c')\n",
        "\n",
        "    # Stage 3 (Default Identity blocks = 3)\n",
        "    X = convolutional_block(X, f = 3, filters = [128,128,512], stage = 3, block='a', s = 2)\n",
        "    for i in range(1,8):\n",
        "      X = identity_block(X, 3, [128, 128, 512], stage=3, block='b'+str(i))\n",
        "\n",
        "    # Stage 4 (Default Identity blocks = 5)\n",
        "    X = convolutional_block(X, f = 3, filters = [256, 256, 1024], stage = 4, block='a', s = 2)\n",
        "    for i in range(1,36):\n",
        "      X = identity_block(X, 3, [256, 256, 1024], stage=4, block='b'+str(i))\n",
        "\n",
        "\n",
        "    # Stage 5\n",
        "    X = convolutional_block(X, f = 3, filters = [512, 512, 2048], stage = 5, block='a', s = 2)\n",
        "    X = identity_block(X, 3, [512, 512, 2048], stage=5, block='b')\n",
        "    X = identity_block(X, 3, [512, 512, 2048], stage=5, block='c')\n",
        "\n",
        "    # First output layer\n",
        "    Xfc = AveragePooling2D(pool_size=(2, 2), padding='valid', name = \"avg_pool\")(X)\n",
        "    Xfc = Flatten()(Xfc)\n",
        "    Xfc = Dense(1000, activation='softmax', name='fc1000' + str(classes))(Xfc)\n",
        "\n",
        "    #Transfer learning from pretrained weights\n",
        "    model = Model(inputs = X_input, outputs = Xfc, name='Cifar10_transfer_learning')\n",
        "    model.load_weights('models/resnet152_weights_tf.h5', by_name=True)\n",
        "\n",
        "    # Switch to the final output layer\n",
        "    Xfc2 = AveragePooling2D((7, 7), name='avg_pool')(X)\n",
        "    Xfc2 = Flatten()(Xfc2)\n",
        "    Xfc2 = Dense(classes, activation='softmax', name='fc'+str(classes))(Xfc2)\n",
        "    \n",
        "    \n",
        "    # Create model\n",
        "    model = Model(inputs = X_input, outputs = Xfc2, name='ResNet150')\n",
        "\n",
        "    return model"
      ],
      "execution_count": null,
      "outputs": []
    }
  ]
}