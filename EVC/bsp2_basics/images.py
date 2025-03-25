import numpy as np
import scipy.ndimage
from PIL import Image

import utils


def read_img(inp: str) -> Image.Image:
    """
        Returns a PIL Image given by its input path.
    """
    img = Image.open(inp)
    return img


def convert(img: Image.Image) -> np.ndarray:
    """
        Converts a PIL image [0,255] to a numpy array [0,1].
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.array(img) / 255
    print(out)

    ### END STUDENT CODE
    return out


def switch_channels(img: np.ndarray) -> np.ndarray:
    """
        Swaps the red and green channel of a RGB image given by a numpy array.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros(img.shape)
    for i in range(img.shape[0]):
        for j in range(img.shape[1]):
            out[i][j][0] = img[i][j][1]
            out[i][j][1] = img[i][j][0]
            out[i][j][2] = img[i][j][2]

    ### END STUDENT CODE

    return out


def image_mark_green(img: np.ndarray) -> np.ndarray:
    """
        returns a numpy-array (HxW) with 1 where the green channel of the input image is greater or equal than 0.7, otherwise zero.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    mask = img[:, :, 1] >= 0.7

    ### END STUDENT CODE

    return mask


def image_masked(img: np.ndarray, mask: np.ndarray) -> np.ndarray:
    """
        sets the pixels of the input image to zero where the mask is 1.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = img.copy()

    mask3d = mask[:, :, np.newaxis]
    mask3d = np.repeat(mask3d, 3, axis=2)

    out[mask3d] = 0

    ### END STUDENT CODE

    return out


def grayscale(img: np.ndarray) -> np.ndarray:
    """
        Returns a grayscale image of the input. Use utils.rgb2gray().
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = utils.rgb2gray(img)

    ### END STUDENT CODE

    return out


def cut_and_reshape(img_gray: np.ndarray) -> np.ndarray:
    """
        Cuts the image in half (x-dim) and stacks it together in y-dim.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros((img_gray.shape[0] * 2, img_gray.shape[1] // 2))

    for i in range(img_gray.shape[0]):
        for j in range(img_gray.shape[1]):
            if j < img_gray.shape[1] // 2:
                out[i + out.shape[0] // 2][j] = img_gray[i][j]
            else:
                out[i - out.shape[0]][j - out.shape[1]] = img_gray[i][j]

    print(out)

    ### END STUDENT CODE

    return out


def filter_image(img: np.ndarray) -> np.ndarray:
    """
        filters the image with the gaussian kernel given below.
    """
    gaussian = utils.gauss_filter(5, 2)

    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    padded = np.pad(img, ((2, 2), (2, 2), (0, 0)), mode='constant')

    out = np.zeros_like(img)

    for c in range(3):
        for i in range(img.shape[0]):
            for j in range(img.shape[1]):
                patch = padded[i:i + 5, j:j + 5, c]
                out[i][j][c] = np.sum(patch * gaussian)


    ### END STUDENT CODE

    return out


def horizontal_edges(img: np.ndarray) -> np.ndarray:
    """
        Defines a sobel kernel to extract horizontal edges and convolves the image with it.
    """
    ### STUDENT CODE
    # TODO: Implement this function.

    # NOTE: The following lines can be removed. They prevent the framework
    #       from crashing.

    out = np.zeros(img.shape)
    sobel_horizontal = np.array([
        [1, 2, 1],
        [0, 0, 0],
        [-1, -2, -1]
    ])

    # Anwendung des Filters mit scipy.ndimage.correlate
    out = scipy.ndimage.correlate(img, sobel_horizontal, mode='constant', cval=0)

    ### END STUDENT CODE

    return out
